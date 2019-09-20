package ui.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.CreateAccountPage;
import ui.pages.MainPage;
import ui.pages.MyAccountPage;
import ui.pages.SignInPage;

public class LogInToExistingAccount {


    WebDriver webDriver;
    MainPage mainPage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    Helper helper;

    public LogInToExistingAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
        mainPage = new MainPage(webDriver);
        signInPage = new SignInPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        helper = new Helper(webDriver);
    }

    public void signInToAccount(String email, String password) {
        mainPage.signInButton.click();
        helper.waitForElementToBeVisible(signInPage.pageTitle);
        Assert.assertTrue(signInPage.pageTitle.isDisplayed());
        signInPage.logInEmail.sendKeys(email);
        signInPage.signInPassword.sendKeys(password);
        signInPage.signInButton.click();
        helper.waitForElementToBeVisible(myAccountPage.accountInfo);
        Assert.assertEquals(myAccountPage.accountInfo.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}