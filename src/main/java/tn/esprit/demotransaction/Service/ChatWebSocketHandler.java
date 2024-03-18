package tn.esprit.demotransaction.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import tn.esprit.demotransaction.Entity.UserLoginRequest;
import tn.esprit.demotransaction.Entity.MessageResponse;
import tn.esprit.demotransaction.Entity.Phoenix;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${chatbot.url}")
    private String chatbotUrl;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        log.info("Payload: " + message.getPayload());
        UserLoginRequest messageDto = mapper.readValue(message.getPayload(), UserLoginRequest.class);

        if (StringUtils.isEmpty(messageDto.getMessage())) return;

        ResponseEntity<MessageResponse> responseEntity;

        try {
            responseEntity = restTemplate.postForEntity(chatbotUrl, messageDto, MessageResponse.class);
        } catch (Exception e) {
            log.info("Session ID: " + session.getId());
            log.error("Happened error", e);
            session.sendMessage(new TextMessage(mapper.writeValueAsString(UserLoginRequest.builder().message("Sorry the bot is not available at this time.").build())));
            return;
        }

        MessageResponse messageResponse = responseEntity.getBody();

        if (Objects.requireNonNull(messageResponse).getType().equalsIgnoreCase("riddles")) {
            Phoenix dto = mapper.convertValue(messageResponse.getData(), Phoenix.class);
            log.info("RiddlesDto:: " + dto);
            TextMessage question = new TextMessage(mapper.writeValueAsString(UserLoginRequest.builder().message(dto.getQuestion()).build()));
            TextMessage answer = new TextMessage(mapper.writeValueAsString(UserLoginRequest.builder().message(dto.getAnswer()).build()));
            session.sendMessage(question);
            TimeUnit.SECONDS.sleep(1);
            session.sendMessage(answer);
        } else {
            TextMessage response = new TextMessage(mapper.writeValueAsString(messageResponse.getData()));
            log.info("Response: " + response.getPayload());
            session.sendMessage(response);
        }

    }
}
