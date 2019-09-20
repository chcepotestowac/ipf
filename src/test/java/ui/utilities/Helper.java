package ui.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class Helper {

    private final WebDriverWait wait;
    protected final WebDriver webDriver;

    protected Helper(WebDriver driver) {
        this.webDriver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public static String getEmail() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        while (email.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String readyEmail = email.toString() + "@email.com";
        return readyEmail;
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




}