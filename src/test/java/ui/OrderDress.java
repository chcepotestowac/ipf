package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.utilities.*;

public class OrderDress {

    private WebDriver webDriver;
    GoToPage goToPage;
    RegisterNewUserFlow registerNewUserFlow;
    LogInToExistingAccount logInToExistingAccount;
    BuyDressFlow buyDressFlow;
    ConfirmOrderFlow confirmOrderFlow;

    String email = Helper.getEmail();
    String password = "zaq12WSX";

    @BeforeTest
    public void beforeTest() {
        webDriver = new ChromeDriver();
        goToPage = new GoToPage(this.webDriver);
        registerNewUserFlow = new RegisterNewUserFlow(this.webDriver);
        logInToExistingAccount = new LogInToExistingAccount(this.webDriver);
        buyDressFlow = new BuyDressFlow(webDriver);
        confirmOrderFlow = new ConfirmOrderFlow(webDriver);
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }

    @Test (description = "buy a dress")
    public void shopping() {
        goToPage.openPageAndCheckElements();
        registerNewUserFlow.fillDataFlow(email, password);
        buyDressFlow.buyPrintedDress();
        confirmOrderFlow.confirmOrderWithPayByWire();
        registerNewUserFlow.logOut();
    }
}
