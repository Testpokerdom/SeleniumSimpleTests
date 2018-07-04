package HeadlessDriving;

import Pokermatch.com.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Pokermatch.com.WebLibrary.*;
import static Pokermatch.com.WebLibrary.clickButton;
import static Pokermatch.com.WebLibrary.recieveCookies;


public class HeadlessTest {

    public static WebDriver driver = null;
    public static MainPage mainPage = null;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "H://Geckodriver_Chrome//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");
        cleanCash();
        mainPage = new MainPage(driver);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testLoginExistingUser(){

        MainPage main = new MainPage(driver);

        goToUrl(driver, "https://beta.pokermatch.com/en#login");
        sendKeysWebElements(main.fieldEmailLogin,"test_bibik",main.fieldPassword,"111111");
        clickButton(main.buttonSignIn);
        Assert.assertEquals(main.elementNickName.getText(),"Your nick:");
        recieveCookies(driver);

    }

    @Test
    public void loginToGitHubAccount(){

        MainPage main = new MainPage(driver);

        goToUrl(driver,"https://github.com/");
        clickButton(main.buttonSignInGitHub);
        sendKeysWebElements(main.fieldLoginGitHub,"ViktorBibik",main.fieldPasswordGitHub,"deadmananor_1");
        clickButton(main.getButtonSignInLoginPopUpGitHub);
        Assert.assertEquals(main.linkPullRequests.getText(), "Pull requests");
        recievePageTitle(driver);
        recieveCookies(driver);
    }
}
