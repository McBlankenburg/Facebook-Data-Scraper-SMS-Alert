package facebookdatascrapersmsalert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Service {

    @Scheduled(fixedRateString = "${SCHEDULED_TIME}")
    public void run() {
        String DATE_TO_SCRAP = "Datę rozpoczęcia zapisów i płatności podamy już wkrótce!";
        if (!FacebookScraper.scrapChristmasBallData().equals(DATE_TO_SCRAP)) {
            SmsSender smsSender = new SmsSender();
            smsSender.sendSms();
        } else {
            log.info("No changed status for event");
        }
    }
}
