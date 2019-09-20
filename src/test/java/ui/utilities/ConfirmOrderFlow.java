package ui.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.*;

public class ConfirmOrderFlow {


    WebDriver webDriver;
    MainPage mainPage;
    DressesPage dressesPage;
    PrintedDressPage printedDressPage;
    SummaryAndOrder summaryAndOrder;
    Helper helper;

    public ConfirmOrderFlow(WebDriver webDriver) {
        this.webDriver = webDriver;
        mainPage = new MainPage(webDriver);
        dressesPage = new DressesPage(webDriver);
        printedDressPage = new PrintedDressPage(webDriver);
        summaryAndOrder = new SummaryAndOrder(webDriver);
        helper = new Helper(webDriver);
    }

    public void confirmOrderWithPayByWire() {
        Assert.assertEquals(summaryAndOrder.description.getText(), "Printed Dress");
        summaryAndOrder.proceedToAddress.click();
        helper.waitForElementToBeVisible(summaryAndOrder.proceedToShippig);
        summaryAndOrder.proceedToShippig.click();
        helper.waitForElementToBeVisible(summaryAndOrder.proceedToPayment);
        summaryAndOrder.acceptToS.click();
        summaryAndOrder.proceedToPayment.click();
        helper.waitForElementToBeVisible(summaryAndOrder.payByWire);
        summaryAndOrder.payByWire.click();
        helper.waitForElementToBeVisible(summaryAndOrder.confirmOrder);
        summaryAndOrder.confirmOrder.click();
        helper.waitForElementToBeVisible(summaryAndOrder.orderConfirmation);
        Assert.assertEquals(summaryAndOrder.orderConfirmation.getText(), "Your order on My Store is complete.");
    }

}