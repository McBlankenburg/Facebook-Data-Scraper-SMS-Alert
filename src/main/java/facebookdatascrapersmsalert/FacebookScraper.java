package facebookdatascrapersmsalert;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FacebookScraper {

    public static String scrapChristmasBallData() {
        String chromedriverPath = FacebookScraper.class.getClassLoader().getResource("chromedriver").getPath();

        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        WebDriver driver = new ChromeDriver();

            String scrappedData = null;
            try {
                driver.get("https://www.facebook.com/events/363657459542851");
                Thread.sleep(2000);
                WebElement declineCookiesButton = driver
                        .findElement(By.xpath("//span[text()='Decline optional cookies']"));

                declineCookiesButton.click();

                Thread.sleep(2000);
                if (!driver.findElements(By.cssSelector("div[aria-label='Close']")).isEmpty()) {
                    WebElement closeButton = driver.findElement(By.cssSelector("div[aria-label='Close']"));
                    closeButton.click();
                }

                WebElement seeMoreButton = driver.findElement(By.cssSelector(".xtlvy1s > .x1i10hfl"));
                seeMoreButton.click();

                WebElement elementToLocate = driver.findElement(By.cssSelector(".x11i5rnm:nth-child(8)"));
                scrappedData = elementToLocate.getText();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.info(e.getMessage() + e.getStackTrace().toString());
            }
            driver.quit();

        return scrappedData;
    }
}