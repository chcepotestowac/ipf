package ui.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.CreateAccountPage;
import ui.pages.MainPage;
import ui.pages.MyAccountPage;
import ui.pages.SignInPage;

public class RegisterNewUserFlow {


    WebDriver webDriver;
    MainPage mainPage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    Helper helper;

    public RegisterNewUserFlow (WebDriver webDriver) {
        this.webDriver = webDriver;
        mainPage = new MainPage(webDriver);
        signInPage = new SignInPage(webDriver);
        createAccountPage = new CreateAccountPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        helper = new Helper(webDriver);
    }

    public void fillDataFlow(String email, String password) {
        mainPage.signInButton.click();
        helper.waitForElementToBeVisible(signInPage.pageTitle);
        Assert.assertTrue(signInPage.pageTitle.isDisplayed());
        signInPage.registerEmail.sendKeys(email);
        signInPage.createAccountButton.click();
        helper.waitForElementToBeVisible(createAccountPage.firstNameField);
        Assert.assertTrue(createAccountPage.firstNameField.isDisplayed());
        createAccountPage.titleMr.click();
        createAccountPage.firstNameField.sendKeys("FirstName");
        createAccountPage.lastNameField.sendKeys("LastName");
        createAccountPage.password.sendKeys(password);
        helper.waitForElementToBeVisible(createAccountPage.doBDay);
        createAccountPage.doBDay.click();
        createAccountPage.doBMonth.click();
        createAccountPage.doBYear.click();
        createAccountPage.addressField.sendKeys("Address 1");
        createAccountPage.cityField.sendKeys("City");
        createAccountPage.state.click();
        helper.waitForElementToBeVisible(createAccountPage.stateChooseCalifornia);
        createAccountPage.stateChooseCalifornia.click();
        createAccountPage.postCodeField.sendKeys("12345");
        createAccountPage.additionalInformationField.sendKeys("additional information");
        createAccountPage.phoneField.sendKeys("1234567");
        createAccountPage.mobilePhoneField.sendKeys("987654");
        createAccountPage.registerButton.click();
        Assert.assertEquals(myAccountPage.accountInfo.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    public void logOut() {
        mainPage.signOutButton.click();
        Assert.assertTrue(mainPage.signInButton.isDisplayed());
    }
}


