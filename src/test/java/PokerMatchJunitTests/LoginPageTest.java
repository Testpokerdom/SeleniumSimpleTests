package PokerMatchJunitTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


import static PokerMatchJunitTests.Helpers.*;


public class LoginPageTest {

    private static final Logger logger = Logger.getLogger(LoginPageTest.class);
    public static WebDriver driver = null;
    public static MainPage mainPage = null;

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.gecko.driver", "H://Geckodriver_FireFox//geckodriver.exe");
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        logger.info("Open website: beta.pokermatch.com");
        goToUrl(driver, "https://beta.pokermatch.com");
    }

    @After
    public void afterEach(){
        driver.quit();
    }

    @Test
    public void test_1_loginValidUser(){
        logger.info("Running test - \"test_1_loginValidUser\"");
        logger.info("Click on the button \"Login\"");
        clickButton(mainPage.buttonLoginBeta);

        logger.info("Enter correct Login and Password to Login pop-up");
        sendTextToWebElement(mainPage.fieldEmailLogin,"test_bibik", mainPage.fieldPassword, "111111");

        logger.info("Click on the button \"Sign in\"");
        clickButton(mainPage.buttonSignIn);

        logger.info("User with nick: " + mainPage.elementNickName.getText() + " is log in:");
        Assert.assertEquals(mainPage.elementNickName.getText(), "Your nick:");
        logger.info("- - - - - - - - - - - - -");
    }

    @Test
    public void test_2_loginInvalidUser(){
        logger.info("Running test - \"test_2_loginInvalidUser\"");
        logger.info("Click on the button \"Login\"");
        clickButton(mainPage.buttonLoginBeta);

        logger.info("Enter incorrect Login and correct Password to Login pop-up");
        sendTextToWebElement(mainPage.fieldEmailLogin,"invalid", mainPage.fieldPassword, "111111");

        logger.info("Click on the button \"Sign in\"");
        clickButton(mainPage.buttonSignIn);

        logger.info("Invalid user is not log in");
        Assert.assertEquals(mainPage.errorMessageLogin.getText(), "Wrong username or password");
        logger.info("- - - - - - - - - - - - -");
    }

    @Test
    public void test_3_emptyFieldsInLoginForm(){
        logger.info("Running test - \"test_3_emptyFieldsInLoginForm\"");
        logger.info("Click on the button \"Login\"");
        clickButton(mainPage.buttonLoginBeta);

        logger.info("Clear email field ");
        clearTextField(mainPage.fieldEmailLogin);

        logger.info("Clear password field ");
        clearTextField(mainPage.fieldPassword);

        logger.info("Click on the button \"Sign in\"");
        clickButton(mainPage.buttonSignIn);

        logger.info("login with empty \"email\" and \"password\" fields imposible");
        Assert.assertEquals(mainPage.errorMessageLogin.getText(), "Wrong username or password");
        logger.info("- - - - - - - - - - - - -");
    }
}
