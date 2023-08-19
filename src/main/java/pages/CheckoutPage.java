package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    WebDriverWait wait;
    private String paymentOption;
    private By successMessage = By.cssSelector(".success-sub-text");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectPaymentOption(String paymentOption) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.paymentOption = paymentOption;
        WebElement paymentOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@aria-labelledby=\"payment-options-heading\"]/descendant::*[text()='" + paymentOption +
                "']")));
        driver.findElement(By.xpath("//*[contains(text(), 'More payment options')]")).click();
        driver.findElement(
                RelativeLocator.with(
                        By.tagName("li")).near(paymentOptionElement)
        ).click();

        System.out.println("--- Selected " + paymentOption + " payment option ---");
    }

    public PayWithCard card() {
        return new PayWithCard(driver);
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        WebElement successMessageElement = driver.findElement(successMessage);
        return successMessageElement.getText();
    }

    public void takeScreenShot() {
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try{
            Files.move(screenshot.toPath(), new File("resources/screenshots/" + "success.png").toPath());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
