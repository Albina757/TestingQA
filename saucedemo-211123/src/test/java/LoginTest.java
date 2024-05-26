import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{



    @Test
    public void validDataWithPO()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //assertEquals("Products",inventoryPage.titleTextIsProducts());
    }


    @Test
    public void invalidPasswordPO() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret");
        loginPage.clickOnTheLoginButton();
        sleep(3000);
        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));
    }


    @Test
    public void validData() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        sleep(3000);

        //Enter the password field

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");

        //Click on Login button

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //Check that log in is successful
        WebElement titleTest = driver.findElement(By.cssSelector("[data-test=\"title\"]"));
        assertEquals("Products", titleTest.getText());

        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryList.isDisplayed());


        //System.out.println(driver.getCurrentUrl()); we will get the url
        assertTrue(driver.getCurrentUrl().contains("/inventory"));

    }

    @Test
    public void invalidPassword() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        sleep(3000);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_password");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorButton = driver.findElement(By.tagName("h3"));
        assertTrue(errorButton.getText().contains("Username and password do not match any user in this service"));

    }

    @Test
    public void invalidUsername() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard");
        sleep(3000);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorButton = driver.findElement(By.tagName("h3"));
        assertTrue(errorButton.getText().contains("Username and password do not match any user in this service"));

    }


    //Empty username
    @Test
    public void emptyUsername() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        sleep(3000);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorButton = driver.findElement(By.tagName("h3"));
        assertEquals("Epic sadface: Username is required", errorButton.getText());

    }

    //Empty password
    @Test
    public void emptyPassword() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        sleep(3000);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorButton = driver.findElement(By.tagName("h3"));
        assertEquals("Epic sadface: Password is required", errorButton.getText());


    }

    @Test
    public void emptyPasswordNUsername() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        sleep(3000);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorButton = driver.findElement(By.tagName("h3"));
        assertEquals("Epic sadface: Username is required", errorButton.getText());

    }


//    @Test
//    public void lockedUser(){
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        userNameInputField.sendKeys("locked_out_user");
//
//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("secret_sauce");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//
//        WebElement header = driver.findElement(By.tagName("h3"));
//        assertTrue(header.getText().contains(" Sorry, this user has been locked out."));
//
//    }

    @Test
    public void lockedUser2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("locked_out_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains(" Sorry, this user has been locked out."));

    }



    //Log out
    @Test
    public void logoutTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        sleep(3000);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products",inventoryPage.titleTextIsProducts());
        SideBar sideBar = new SideBar(driver);
        sideBar.clickOnBurgerMenuButton();
        sideBar.followTheLogoutLink();


        //Check that logout is successful

        assertTrue(loginPage.usernameInputFieldIsDisplayed());
    }
}