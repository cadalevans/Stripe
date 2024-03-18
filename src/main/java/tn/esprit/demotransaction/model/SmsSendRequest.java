package tn.esprit.demotransaction.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
public class SmsSendRequest {

    private  String destinationSMSNumber;
    private String smsMessage;
}
