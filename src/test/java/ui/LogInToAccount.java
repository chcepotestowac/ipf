package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.utilities.*;

public class LogInToAccount {

    private WebDriver webDriver;
    GoToPage goToPage;
    RegisterNewUserFlow registerNewUserFlow;
    LogInToExistingAccount logInToExistingAccount;

    String email = Helper.getEmail();
    String password = "zaq12WSX";

    @BeforeTest
    public void beforeTest() {
        webDriver = new ChromeDriver();
        goToPage = new GoToPage(this.webDriver);
        registerNewUserFlow = new RegisterNewUserFlow(this.webDriver);
        logInToExistingAccount = new LogInToExistingAccount(this.webDriver);
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }


@Test (description = "log in to existing account")
    public void logIn() {
        goToPage.openPageAndCheckElements();
        registerNewUserFlow.fillDataFlow(email, password);
        registerNewUserFlow.logOut();
        logInToExistingAccount.signInToAccount(email, password);
        registerNewUserFlow.logOut();
    }
}
