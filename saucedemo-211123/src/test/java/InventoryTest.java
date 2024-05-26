import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void itemsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals(6, inventoryPage.getItemQuantity());
        //check that all items are displayed
        assertTrue(inventoryPage.allItemsAreDisplayed());
        //check that all item names are displayed
        assertTrue(inventoryPage.allItemsNamesAreDisplayed());
        //all item names are NOT empty
        assertTrue(inventoryPage.allItemNameAreNotEmpty());
        //all items name starts with "Sauce Labs"
        //assertTrue(inventoryPage.allItemsNameStartWithSauce());//test should fail!
    }

    @Test
    public void add3ItemsTest() {
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
        //Check that cart icon has badge with text "3"
        assertEquals("3", inventoryPage.getItemsQuantityCartBadge());
    }


    @Test
    public void sortPriceLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.choosePriceLowToHighSortOption();
        //check that sort is correct
        inventoryPage.checkPriceSortFromLowToHigh();

    }

    @Test
    public void sortPriceHighToLow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.choosePriceHighToLowSortOption();
        //check that sort is correct
        inventoryPage.checkPriceSortFromHighToLow();
    }

    //Check that sort by name works correct
    //1.Alphabetical order
    @Test
    public void sortNameAlphOrder() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.chooseAlphOrderSortOption();
        inventoryPage.checkNamesSortAlphOrder();

    }


    @Test
    public void sortNameReverseAlphOrder() {
        //2.reverse alph order
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.chooseReverseAlphOrderOption();
        inventoryPage.checkNamesSortReverseAlphOrder();

    }

}



