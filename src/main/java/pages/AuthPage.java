package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By otpInput = By.id("fake_otp");
    private By captchaInput = By.id("captcha-input");
    private By submitButton = By.id("mocksubmit");
    private By captchaSubmitButton = By.id("captcha-submit");
    private By accountNumberInput = By.id(".fake_otp[type='text']");

    public AuthPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterOtp(String otp, String paymentType) {

        if (paymentType.equals("card")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(otpInput));
            WebElement otpInputElement = driver.findElement(otpInput);
            otpInputElement.sendKeys(otp);
        }

        if (paymentType.equals("bank")) {

        }

    }

    public CheckoutPage submit() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        submitButtonElement.click();

        return new CheckoutPage(driver);
    }
}
