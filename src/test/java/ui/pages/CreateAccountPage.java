package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    String day = "3";

    public CreateAccountPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (css = "#id_gender1")
    public WebElement titleMr;

    @FindBy (css = "#customer_firstname")
    public WebElement firstNameField;

    @FindBy (css = "#customer_lastname")
    public WebElement lastNameField;

    @FindBy (css = "#passwd")
    public WebElement password;

    @FindBy (xpath = "//div[@id='uniform-days']//option[3]")
    public WebElement doBDay;

    @FindBy (xpath = "//option[contains(text(),'April')]")
    public WebElement doBMonth;

    @FindBy (xpath = "//option[contains(text(),'1982')]")
    public WebElement doBYear;

    @FindBy (css = "#firstname")
    public WebElement firstNameAddressField;

    @FindBy (css = "#lastname")
    public WebElement lastNameAddressField;

    @FindBy (css = "#address1")
    public WebElement addressField;

    @FindBy (css = "#city")
    public WebElement cityField;

    @FindBy (css = "#id_state")
    public WebElement state;

    @FindBy (css = "#id_state >[value='5']")
    public WebElement stateChooseCalifornia;

    @FindBy (css = "#postcode")
    public WebElement postCodeField;

    @FindBy (css = "#other")
    public WebElement additionalInformationField;

    @FindBy (css = "#phone")
    public WebElement phoneField;

    @FindBy (css = "#phone_mobile")
    public WebElement mobilePhoneField;

    @FindBy (css = "#address_alias")
    public WebElement addressAliasField;

    @FindBy (css = "#submitAccount")
    public WebElement registerButton;
}