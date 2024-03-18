package tn.esprit.demotransaction.Config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class TwilioInitializer {
/*
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
    private TwilioConfig twilioConfiguration;
    @Autowired
    public TwilioInitializer(TwilioConfig twilioConfiguration){
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(twilioConfiguration.getAccountSid(),twilioConfiguration.getAccountSid());

        LOGGER.info("Twillio initialized ... with accountsid {}",twilioConfiguration.getAccountSid());
    }

 */

}
