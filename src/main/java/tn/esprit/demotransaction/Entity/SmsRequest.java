package tn.esprit.demotransaction.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmsRequest {

    private  String phoneNumber; // destination
    private String message;
}
