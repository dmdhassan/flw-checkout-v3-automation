package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CheckoutPage;
import payment_details.Payment;
import utils.WindowManager;

public class BaseTests {
    private WebDriver driver;
    protected CheckoutPage checkout;
    Payment payment = new Payment(
            "NG",
            "NGN",
            311,
            "08141745803",
            "firstName",
            "lastName",
            "hassanyahya@gmail.com",
            "Bank",
            "FLWPUBK-6cbb62c7b01a981fb38406604ab3727e-X"
    );

    String checkoutLink = payment.getLink();



    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        checkout = new CheckoutPage(driver);
        driver.manage().window().maximize();
        driver.get(checkoutLink);

        System.out.println(driver.getTitle());
    }

//    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}
