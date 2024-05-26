import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest{
    @Test
    public void add3ItemsTest(){
        //Add 3 items to the cart

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnAddLightToCart();
        inventoryPage.clickOnAddTShirtToCart();
        inventoryPage.clickOnShoppingCartIcon();
        //Check that cart icon has badge with text "3"
        CartPage cartPage = new CartPage(driver);
        assertEquals(3, cartPage.getAddedItemsQuantity());
    }

    @Test
    public void cart1ItemTest(){
        //auth
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //add 1 item to the cart
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShoppingCartIcon();
        //go to Cart page
        CartPage cartPage = new CartPage(driver);

        //check that 1 item in the list
        assertEquals(1,cartPage.getAddedItemsQuantity());
        //check that item name from Cart page equals to item name, which was added
        assertEquals(inventoryPage.getNameOfTheFirstItem(),cartPage.getNameOfFirstItem());

    }

    @Test
    public void cart5ItemsTest()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnAddLightToCart();
        inventoryPage.clickOnAddTShirtToCart();
        inventoryPage.clickOnAddJacketToCart();
        inventoryPage.clickOnAddOnesieToCart();
        inventoryPage.clickOnShoppingCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertEquals(5,cartPage.getAddedItemsQuantity());


    }


}
