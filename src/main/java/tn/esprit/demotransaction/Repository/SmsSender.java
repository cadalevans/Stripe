package tn.esprit.demotransaction.Repository;

import tn.esprit.demotransaction.Entity.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
