package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (css = ".info-account")
    public WebElement accountInfo;
}