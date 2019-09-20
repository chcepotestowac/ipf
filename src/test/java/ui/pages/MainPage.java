package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
        @FindBy (css = ".logo")
        public WebElement logo;

        @FindBy (css = ".login")
        public WebElement signInButton;

        @FindBy (css = "[title='Log me out']")
        public WebElement signOutButton;

        @FindBy (xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
        public WebElement women;

        @FindBy (css = "#subcategories > ul > li [title='Dresses']")
        public WebElement dresses;

        @FindBy (css = "#subcategories > ul > li [title='Evening Dresses']")
        public WebElement eveningDressesCategory;
}

