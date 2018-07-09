package PokerMatchTestNGTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static PokerMatchTestNGTests.WebLibrary.*;

public class TestsForSignIn {

    public static WebDriver driver = null;
    private static final Logger logger = Logger.getLogger(TestsForSignIn.class);

    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.gecko.driver", "H://Geckodriver_FireFox//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void shutDown(){

        driver.quit();
    }

    @Test(priority=1)
    public void testLoginExistingUser(){
        MainPage main = new MainPage(driver);

        logger.info("Running test - \"testLoginExistingUser\"");
        logger.info("Open website: beta.pokermatch.com");
        goToUrl(driver, "https://beta.pokermatch.com");

        logger.info("Click on the button \"Login\"");
        clickButton(main.buttonLoginBeta);

        logger.info("Enter correct Login and Password to Login form");
        sendKeysWebElements(main.fieldEmailLogin,"test_bibik",main.fieldPassword,"111111");

        logger.info("Click on the button \"Sign in\"");
        clickButton(main.buttonSignIn);

        logger.info("User with nick: " + main.elementNickName.getText() + " is log in:");
        Assert.assertEquals(main.elementNickName.getText(),"Your nick:");

        logger.info("Click on the button \"LogOut\", user was logged out");
        clickButton(main.buttonLogOutBeta);
        logger.info("Test \"testLoginExistingUser\" finished successfully");
        logger.info("- - - - - - - - - - - - -");
    }

    @Test(priority=2)
    public void testLoginUnExistingUser() throws Exception {
        MainPage main2 = new MainPage(driver);

        logger.info("Running test - \"testLoginExistingUser\"");
        logger.info("Open website: beta.pokermatch.com");
        goToUrl(driver, "https://beta.pokermatch.com");

        logger.info("Click on the button \"Login\"");
        clickButton(main2.buttonLoginBeta);

        logger.info("Enter incorrect Login and correct Password to Login pop-up");
        sendKeysWebElements(main2.fieldEmailLogin,"unexistin",main2.fieldPassword,"111111");

        logger.info("Click on the button \"Sign in\"");
        clickButton(main2.buttonSignIn);

        logger.info("User was not logged in, error message with text" + main2.errorMessageLogin.getText() + " - has appeared");
        Assert.assertEquals(main2.errorMessageLogin.getText(),"Wrong username or password");
        logger.info("Test \"testLoginUnExistingUser\" finished successfully");
        logger.info("- - - - - - - - - - - - -");
    }

    @Test(priority=3)
    public void testLoginEmptyFields(){
        MainPage main3 = new MainPage(driver);

        logger.info("Running test - \"testLoginExistingUser\"");
        logger.info("Open website: beta.pokermatch.com");
        goToUrl(driver,"https://beta.pokermatch.com");

        logger.info("Click on the button \"Login\"");
        clickButton(main3.buttonLoginBeta);

        logger.info("Clear Email field and leave it empty");
        clearTextField(main3.fieldEmailLogin);

        logger.info("Clear Password field and leave it empty");
        clearTextField(main3.fieldPassword);

        logger.info("Click on the button \"Sign in\"");
        clickButton(main3.buttonSignIn);

        logger.info("User was not logged in, error message with text" + main3.errorMessageLogin.getText() + " - has appeared");
        Assert.assertEquals(main3.errorMessageLogin.getText(),"Wrong username or password");
        logger.info("Test \"testLoginEmptyFields\" finished successfully");
        logger.info("- - - - - - - - - - - - -");
    }

    @Test(priority = 4)
    public void testLoginAsExistingUser(){
        MainPage main4 = new MainPage(driver);

        logger.info("Duplicated test for valid login was running");
        driver.get("https://beta.pokermatch.com");
        main4.buttonLoginBeta.click();
        main4.fillLoginForm("test_bibik","111111");
        main4.buttonSignIn.click();
        Assert.assertEquals(main4.elementNickName.getText(),"Your nick:");
        main4.buttonLogOutBeta.click();
        logger.info("Duplicated test for valid login was running - test finished successfully");
        logger.info("- - - - - - - - - - - - -");
    }

}
