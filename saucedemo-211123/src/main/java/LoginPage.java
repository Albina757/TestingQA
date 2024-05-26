import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessageText;

    public void enterValueToUsername(String usernameValue){
        enterTextToElement(usernameValue, usernameInputField);
        //usernameInputField.sendKeys(usernameValue);
    }

    public void enterValueToPasswordInputField(String passwordValue){
        enterTextToElement(passwordValue, passwordInputField);
    }

    public void clickOnTheLoginButton(){
        clickOnElement(loginButton);
    }

    public String getErrorMessageText(){
        return errorMessageText.getText();
    }


    public boolean usernameInputFieldIsDisplayed() {
        return usernameInputField.isDisplayed();
    }
}