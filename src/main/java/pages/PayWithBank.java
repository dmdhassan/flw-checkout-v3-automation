package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayWithBank {
    private WebDriver driver;
    private WebDriverWait wait;
    private By payButton = By.cssSelector(".btn.base");
    private By redirectWrapper = By.cssSelector(".redirect-wrapper");

    public PayWithBank(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public AuthPage clickPay() {
        driver.findElement(payButton).click();

        if (true) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(redirectWrapper));
            driver.findElement(payButton).click();

            return new AuthPage(driver);
        }

        return null;
    }


}
