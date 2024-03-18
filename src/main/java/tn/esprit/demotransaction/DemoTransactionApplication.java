package tn.esprit.demotransaction;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tn.esprit.demotransaction.Config.TwilioConfig;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoTransactionApplication {


   @Autowired
    private TwilioConfig twilioConfig;




    public static void main(String[] args) {
        SpringApplication.run(DemoTransactionApplication.class, args);
    }

}
