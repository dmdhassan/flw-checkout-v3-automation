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
    private By submitButton = By.id("mocksubmit");

    public AuthPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterOtp(String otp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(otpInput));
        WebElement otpInputElement = driver.findElement(otpInput);
        otpInputElement.sendKeys(otp);
    }

    public CheckoutPage submit() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        submitButtonElement.click();

        return new CheckoutPage(driver);
    }
}
