package checkout;

import base.BaseTests;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTests extends BaseTests {


    @Test
    public void verifyThatMerchantNameIsDisplayed() {
        checkout.selectPaymentOption("Bank");
    }

    @Test
    public void verifyThatCustomerEmailIsDisplayed() {
        System.out.println("Hello");
    }

    @Test
    public void verifyThatAmountIsDisplayed() {
        System.out.println("Hello");
    }

    @Test
    public void verifyThatCurrencyIsDisplayed() {
        System.out.println("Hello");
    }

}
