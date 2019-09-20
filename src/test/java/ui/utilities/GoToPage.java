package ui.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.MainPage;

public class GoToPage {

    WebDriver webDriver;
    MainPage mainPage;

    public GoToPage (WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        this.webDriver = webDriver;
    }

    public void openPageAndCheckElements() {
        webDriver.get("http://automationpractice.com");
        Assert.assertTrue(mainPage.logo.isDisplayed());
        Assert.assertTrue(mainPage.signInButton.isDisplayed());
    }
}
