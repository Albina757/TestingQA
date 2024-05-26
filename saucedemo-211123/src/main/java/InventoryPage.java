import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        super(driver);}

    @FindBy(css = "[data-test=\"title\"]")
    private WebElement tittleText;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addLightToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addTShirtToCart;

    @FindBy(id= "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addJacketToCart;


    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addOnesieToCart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartIcon;

    @FindBy(css = "[data-test=\"product-sort-container\"]")
    private WebElement sortDropdown;

    @FindBy(css = "[value=\"lohi\"]")
    private WebElement priceLowToHigh;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(css = "[value=\"hilo\"]")
    private WebElement priceHighLow;

    @FindBy(css = "[value=\"az\"]")
    private WebElement alphOrderSort;

    @FindBy(css = "[value=\"za\"]")
    private WebElement reverseAlphOrder;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames;

    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }



    public int getItemQuantity(){
        return items.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item: items) {
            if(!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemsNamesAreDisplayed(){
        boolean displayed = true;
        for (WebElement itemName: itemNames) {
            if (!itemName.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNameAreNotEmpty(){
        boolean notEmpty = true;
        for (WebElement itemName: itemNames) {
            if (itemName.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }




    public boolean allItemsNameStartWithSauce(){
        boolean startWithSauce = true;
        for (WebElement itemName: itemNames){
            if (itemName.getText().startsWith("Sauce Labs")){
                startWithSauce = false;
            }
        }
        return startWithSauce;
    }

    public String titleTextIsProducts() {
       return getTextOfElement(tittleText);
    }

    public void clickOnAddToCartButton(){
        addBackpackToCart.click();
    }

   public String getItemsQuantityCartBadge(){
        return cartBadge.getText();
   }

   public void clickOnAddLightToCart(){
        addLightToCart.click();
   }

   public void clickOnAddTShirtToCart(){
        addTShirtToCart.click();
   }

   public void clickOnShoppingCartIcon(){
        shoppingCartIcon.click();
   }

   public void clickOnAddJacketToCart(){
        addJacketToCart.click();
   }

   public void clickOnAddOnesieToCart(){
        addOnesieToCart.click();
   }

    public String getNameOfTheFirstItem(){
        return itemNames.get(0).getText();
}

    public void choosePriceLowToHighSortOption(){
        sortDropdown.click();
        priceLowToHigh.click();
    }

    public boolean checkPriceSortFromLowToHigh(){
    List<Double> actualPrices = new ArrayList<>();
        for (WebElement price:inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);
        return actualPrices.equals(expectedPrices);
    }

    public void choosePriceHighToLowSortOption(){
        sortDropdown.click();
        priceHighLow.click();
    }

    public boolean checkPriceSortFromHighToLow(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price:inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices, reverseOrder());
        return actualPrices.equals(expectedPrices);
    }

    public void chooseAlphOrderSortOption(){
        sortDropdown.click();
        alphOrderSort.click();
    }

    public boolean checkNamesSortAlphOrder(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name: inventoryNames) {
            actualNames.add(name.getText());
        }

        List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames);
        return actualNames.equals(expectedNames);
    }


    public void chooseReverseAlphOrderOption(){
        sortDropdown.click();
        reverseAlphOrder.click();
    }
    public boolean checkNamesSortReverseAlphOrder() {
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }

        List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames, reverseOrder());
        return actualNames.equals(expectedNames);
    }

}



