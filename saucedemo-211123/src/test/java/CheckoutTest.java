import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void successCheckout() throws InterruptedException {
       //log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        //Add 3 items to the cart

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnAddLightToCart();
        inventoryPage.clickOnAddTShirtToCart();
        //Check that cart icon has badge with text "3"
        assertEquals("3", inventoryPage.getItemsQuantityCartBadge());
        inventoryPage.clickOnShoppingCartIcon();
        // checkout 1 page is displayed
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage stepOnePage = new CheckoutStepOnePage(driver);
        assertTrue(stepOnePage.firstNameInputFieldIsDisplayed());

        //
        stepOnePage.enterValueToFirstNameInputField("Susan");
        stepOnePage.enterValueToLastNameInputField("Lawrence");
        stepOnePage.enterValueToZipCodeInputField("11506");
        sleep(3000);
        stepOnePage.clickOnContinueButton();

      CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage(driver);
      sleep(3000);
      stepTwoPage.clickOnFinishButton();

      CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
      assertTrue(completePage.completeHeaderIsDisplayed());

    }
}
