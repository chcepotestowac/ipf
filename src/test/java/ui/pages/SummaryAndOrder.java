package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryAndOrder {

    public SummaryAndOrder(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (css = ".breadcrumb ")
    public WebElement breadcrum;

    @FindBy (css = ".cart_description > p")
    public WebElement description;

    @FindBy (css = ".standard-checkout ")
    public WebElement proceedToAddress;


    @FindBy (css = "[name='processAddress']")
    public WebElement proceedToShippig;

    @FindBy (css = "#cgv")
    public WebElement acceptToS;

    @FindBy (css = "[name='processCarrier']")
    public WebElement proceedToPayment;

    @FindBy (css = ".bankwire")
    public WebElement payByWire;

    @FindBy (xpath = "//span[contains(text(),'I confirm my order')]")
    public WebElement confirmOrder;

    @FindBy (css = ".cheque-indent")
    public WebElement orderConfirmation;
}