package Pokermatch.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static Pokermatch.com.WebLibrary.*;

public class TestsForSignIn {

    public static WebDriver driver = null;
    public static MainPage mainPage = null;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "H://Geckodriver_Chrome//chromedriver.exe");
        mainPage = new MainPage(driver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void loginToGitHubAccount(){

        MainPage main = new MainPage(driver);
        goToUrl(driver,"https://github.com/");
        clickButton(main.buttonSignInGitHub);
        setTextIntoWebElements(main.fieldLoginGitHub,"ViktorBibik",main.fieldPasswordGitHub,"deadmananor_1");
        Assert.assertEquals(main.linkPullRequests.getText(), "Pull requests");

    }
    /*
    @Test
    public void testBasePage(){


        goToUrl(driver, "https://beta.pokermatch.com/en");
        System.out.println("Url was used");
        clickButton(main.buttonLoginBeta);
        System.out.println("Login button was clicked");
        setTextIntoWebElements(main.fieldEmailLogin,"test_bibik",main.fieldPassword, "111111");
        System.out.println("Login form was filled");

    }
    */
    @Test
    public void sendTextToGoogle(){

        MainPage main = new MainPage(driver);

        goToUrl(driver, "https://www.google.com/");
        //System.out.println("Page title is: " + driver.getTitle());
        setTextIntoWebElement(main.fieldSearchOnGooglePage,"Selenium");
        //System.out.println("Page title is: " + driver.getTitle());

    }

    @AfterClass
    public static void shutDown(){

        driver.close();
    }
}
