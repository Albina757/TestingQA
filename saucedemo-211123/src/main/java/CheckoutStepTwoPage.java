import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BasePage{
    WebDriver driver;

    public CheckoutStepTwoPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void clickOnFinishButton(){
        finishButton.click();
    }

}
