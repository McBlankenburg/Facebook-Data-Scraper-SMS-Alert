package facebookdatascrapersmsalert;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SmsSender {

    @Value("${SMS_SENDER.ACCOUNT_SID}")
    private String ACCOUNT_SID;

    @Value("${SMS_SENDER.AUTH_TOKEN}")
    private String AUTH_TOKEN;

    public void sendSms() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber("+48880226118"),
                        new PhoneNumber("+12053862276"),
                        "Na stronie https://www.facebook.com/events/363657459542851 nastąpiła zmiana ")
                .create();

        System.out.println("Message SID: "+ message.getSid());
    }
}
