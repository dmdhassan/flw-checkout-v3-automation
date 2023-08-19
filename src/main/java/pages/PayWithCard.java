package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayWithCard {
    private WebDriver driver;
    private WebDriverWait wait;
    private By cardNumberInput = By.id("cardnumber");
    private By expiryDateInput = By.id("expiry");
    private By cvvInput = By.id("cvv");
    private By payButton = By.cssSelector(".btn.base");
    private By redirectWrapper = By.cssSelector(".redirect-wrapper");

    public PayWithCard(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterCardCredentials(String cardNumber, String expiryDate, String cvv) {

        driver.findElement(cardNumberInput).sendKeys(cardNumber);
        driver.findElement(cvvInput).sendKeys(cvv);

        for (int i = 0; i < expiryDate.length(); i++) {
            char c = expiryDate.charAt(i);
            driver.findElement(expiryDateInput).sendKeys(String.valueOf(c));
        }


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
