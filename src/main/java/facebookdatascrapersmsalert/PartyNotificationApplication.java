package facebookdatascrapersmsalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PartyNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartyNotificationApplication.class, args);
    }
}
