package checkout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayWithCardTests extends BaseTests {
    @Test
    public void verifySuccessfulCardPayment() {
        checkout.selectPaymentOption("Card");
        pages.PayWithCard card = checkout.card();
        card.enterCardCredentials("4242 4242 4242 4242", "1223", "123");

        var authPage = card.clickPay();
        getWindowManager().switchToTab("rave-api");

        authPage.enterOtp("123456", "card");
        authPage.submit();

        getWindowManager().switchToTab("checkout-v3");

        String expectedSuccessMessage = "Your transaction was completed successfully.";
        String actualSuccessMessage = checkout.getSuccessMessage();

        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
        checkout.takeScreenShot();

    }
}
