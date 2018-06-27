package Pokermatch.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class WebLibrary{

    public static void goToUrl(WebDriver driver, String url){

        driver.get(url);
    }

    public static void cliclWebElement(WebElement element){

        element.click();
    }

    public static void clickButton(WebElement button){

        button.click();
    }

    public static boolean isElementDisplayed(WebElement element){
        boolean isElementDisplayed = element.isDisplayed();
        return isElementDisplayed;
    }

    public static void elementAssert(WebElement element, String assertText){

        String a = element.getText();
        Assert.assertEquals(element,a);

    }

    public static void setTextIntoWebElements(WebElement element1, String login, WebElement element2, String password ){

        element1.click();
        clearTextField(element1);
        element1.sendKeys(login);
        element2.click();
        clearTextField(element2);
        element2.sendKeys(password);
        element2.submit();

    }

    public static boolean isElementEnabled(WebElement element){

        return element.isEnabled();
    }

    public static void sendText(WebElement element, String text){

        element.sendKeys(text);
    }

    public static void clearTextField(WebElement element){
        element.clear();

    }
    public static void setTextIntoWebElement(WebElement element, String text ){
        element.click();
        clearTextField(element);
        element.sendKeys(text);
        element.submit();
    }

    public static boolean isElementPresent (WebDriver driver, String xpath) throws Exception{

        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        int numberOfElements = elements.size();

        if (numberOfElements==0){
            return false;
        }else if (numberOfElements==1){
            return true;

        }else {
            throw new Exception("There are more than 1 elemnt with current locator on the page");
        }

    }

    public static void waitElementPresent(WebDriver driver,long seconds,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
