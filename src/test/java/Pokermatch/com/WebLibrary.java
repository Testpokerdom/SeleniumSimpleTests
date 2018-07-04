package Pokermatch.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class WebLibrary{
    public static WebDriver driver = null;

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

    public static void sendKeysWebElements(WebElement element1, String login, WebElement element2, String password ){

        clearTextField(element1);
        element1.sendKeys(login);
        clearTextField(element2);
        element2.sendKeys(password);
        //element2.submit();

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

    public static void cleanCash(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, opts);
    }

    public static Set<Cookie> recieveCookies(WebDriver driver){
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies from website: " + cookies);
        return cookies;
    }

    public static String recievePageTitle(WebDriver driver){

        String pageTitle = driver.getTitle();
        System.out.println("Page title is " + pageTitle);
        return pageTitle;
    }

}
