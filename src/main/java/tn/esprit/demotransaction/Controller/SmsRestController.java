package tn.esprit.demotransaction.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.demotransaction.Entity.SmsRequest;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SmsRestController {
    @PostMapping("/processSMS")
    public String processSMS(@RequestBody SmsRequest sendRequest){
        log.info("processSMS Started sendRequest:" + sendRequest.toString());
        return "todo";
    }
}
