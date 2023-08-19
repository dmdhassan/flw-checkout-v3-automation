package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RelativeLocators {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jumia.com.ng/");

        System.out.println("Title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void testRelativeLocator() {
        Duration timeout = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-login-title")));

        var loginTitle = driver.findElement(By.cssSelector(".orangehrm-login-title"));
        WebElement loginCredentials = driver.findElement(RelativeLocator.with(
                By.tagName("p"))
                .below(loginTitle));
        System.out.println(loginCredentials.getText());


        List<WebElement> allSocialMedia = driver.findElements(with(
                By.tagName("a"))
                .near(By.className("orangehrm-login-footer-sm")));

        for (WebElement socialMedia: allSocialMedia) {
            System.out.println(socialMedia.getAttribute("href"));
        }
    }

    @Test
    public void newWindowTab() {
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
        newWindow.get("https://my.jumia.com.ng/");
        driver.findElement(By.linkText("About Jumia")).click();

        System.out.println("Title: " + driver.getTitle());

        Set<String> allWindowTabs = driver.getWindowHandles();
        Iterator<String> iterator = allWindowTabs.iterator();

        String mainFirstWindow = iterator.next();
        driver.switchTo().window(mainFirstWindow);
        System.out.println("Title: " + driver.getTitle());

        driver.findElement(By.id("fi-q")).sendKeys(" toy");
        driver.findElement(By.cssSelector(".btn._prim._md.-mls.-fsh0")).click();

    }

}