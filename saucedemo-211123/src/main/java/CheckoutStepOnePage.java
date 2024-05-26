import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage{
    WebDriver driver;

    public CheckoutStepOnePage(WebDriver driver) {
       super(driver);
    }
    @FindBy(id="first-name")
    private WebElement firstNameInputField;


    @FindBy(id = "last-name")
    private WebElement lastNameInputField;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInputField;

    @FindBy(id="continue")
    private WebElement continueButton;

    public void enterValueToFirstNameInputField(String firstNameValue) {
        firstNameInputField.sendKeys("Susan");
    }

    public void enterValueToLastNameInputField(String lastNameValue) {
        lastNameInputField.sendKeys("Lawrence");
    }

    public boolean firstNameInputFieldIsDisplayed(){
        return firstNameInputField.isDisplayed();
    }

    public void enterValueToZipCodeInputField(String zipCodeValue){
        zipCodeInputField.sendKeys("11506");
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
