package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {

    public DressesPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (css = ".page-heading")
    public WebElement heading;

    @FindBy (css = ".product_img_link [title='Printed Dress']")
    public WebElement printedDress;
}

