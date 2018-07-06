package PokerMatchJunitTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    public static void goToUrl(WebDriver driver, String url){
        driver.get(url);
    }

    public static void clickButton(WebElement button){
        button.click();
    }

    public static void clickElement(WebElement element){
        element.click();
    }

    public static void clearTextField(WebElement textField){
        textField.clear();
    }

    public static void sendTextToWebElement(WebElement firstField, String login, WebElement secondField, String password){
        firstField.clear();
        firstField.sendKeys(login);
        secondField.clear();
        secondField.sendKeys(password);
    }

    public static boolean isElementDisplayed(WebElement element){
        boolean elementDisplayed = element.isDisplayed();
        return elementDisplayed;
    }

    public static boolean isElementEnabled(WebElement element){
        boolean elementDisplayed = element.isEnabled();
        return elementDisplayed;
    }

    public static void waitElementPresent(WebDriver driver,long seconds,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
