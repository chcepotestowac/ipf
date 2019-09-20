package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (css = ".page-heading")
    public WebElement pageTitle;

    @FindBy (css = "#email_create")
    public WebElement registerEmail;

    @FindBy (css = "#SubmitCreate")
    public WebElement createAccountButton;

    @FindBy (css = "#email")
    public WebElement logInEmail;

    @FindBy (css = "#passwd")
    public WebElement signInPassword;

    @FindBy (css = "#SubmitLogin")
    public WebElement signInButton;
}
