package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.utilities.*;

public class CreateAccount {

    private WebDriver webDriver;
    GoToPage goToPage;
    RegisterNewUserFlow registerNewUserFlow;

    String email = Helper.getEmail();
    String password = "zaq12WSX";

@BeforeTest
    public void beforeTest() {
        webDriver = new ChromeDriver();
        goToPage = new GoToPage(this.webDriver);
        registerNewUserFlow = new RegisterNewUserFlow(this.webDriver);
    }

@AfterTest
    public void afterTest() {
        webDriver.quit();
    }


@Test (description = "create new account")
    public void register() {
        System.out.println(email);
        goToPage.openPageAndCheckElements();
        registerNewUserFlow.fillDataFlow(email, password);
        registerNewUserFlow.logOut();
    }
}
