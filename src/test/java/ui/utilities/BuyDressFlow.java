package ui.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.*;

public class BuyDressFlow {


    WebDriver webDriver;
    MainPage mainPage;
    DressesPage dressesPage;
    PrintedDressPage printedDressPage;
    SummaryAndOrder summaryAndOrder;
    Helper helper;

    public BuyDressFlow (WebDriver webDriver) {
        this.webDriver = webDriver;
        mainPage = new MainPage(webDriver);
        dressesPage = new DressesPage(webDriver);
        printedDressPage = new PrintedDressPage(webDriver);
        summaryAndOrder = new SummaryAndOrder(webDriver);
        helper = new Helper(webDriver);
    }

    public void buyPrintedDress() {
        mainPage.logo.click();
        helper.waitForElementToBeVisible(mainPage.women);
        mainPage.women.click();
        mainPage.dresses.click();
        mainPage.eveningDressesCategory.click();
        helper.waitForElementToBeVisible(dressesPage.printedDress);
        dressesPage.printedDress.click();
        helper.waitForElementToBeClickable(printedDressPage.addToCart);
        printedDressPage.sizeDrop.click();
        printedDressPage.sizeLClick.click();
        printedDressPage.addToCart.click();
        helper.waitForElementToBeVisible(printedDressPage.checkout);
        printedDressPage.checkout.click();
        helper.waitForElementToBeVisible(summaryAndOrder.description);
        Assert.assertEquals(summaryAndOrder.breadcrum.getText(), "> Your shopping cart");
    }
}