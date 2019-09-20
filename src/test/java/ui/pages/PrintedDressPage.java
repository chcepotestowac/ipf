package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintedDressPage {

    public PrintedDressPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (css = ".pb-center-column")
    public WebElement dressTitle;

    @FindBy (css = "#uniform-group_1")
    public WebElement sizeDrop;

    @FindBy (css = "#group_1 > [title='L']")
    public WebElement sizeLClick;

    @FindBy (css = "#add_to_cart > button")
    public WebElement addToCart;

    @FindBy (css = "[title='Proceed to checkout']")
    public WebElement checkout;
}