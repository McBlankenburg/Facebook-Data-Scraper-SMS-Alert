package facebookdatascrapersmsalert;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Service {

    @Scheduled(fixedRate = 500)
    public void run() {
        String DATE_TO_SCRAP = "Datę rozpoczęcia zapisów i płatności podamy już wkrótce!";
        if (!FacebookScraper.scrapChristmasBallData().equals(DATE_TO_SCRAP)) {
            SmsSender.sendSms();
        } else {
            System.out.println("No changed data");
        }
    }
}
