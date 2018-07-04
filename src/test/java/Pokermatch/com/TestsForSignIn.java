package Pokermatch.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static Pokermatch.com.WebLibrary.*;

public class TestsForSignIn {

    public static WebDriver driver = null;
    public static MainPage mainPage = null;
    public static MainPageRegistrationForm registrationForm = new MainPageRegistrationForm(driver);

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "H://Geckodriver_Chrome//chromedriver.exe");
        //cleanCash();
        mainPage = new MainPage(driver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void shutDown(){

        driver.quit();
    }

    @Test
    public void testLoginExistingUser(){

        MainPage main = new MainPage(driver);

        goToUrl(driver, "https://beta.pokermatch.com/en#login");
        sendKeysWebElements(main.fieldEmailLogin,"test_bibik",main.fieldPassword,"111111");
        clickButton(main.buttonSignIn);
        Assert.assertEquals(main.elementNickName.getText(),"Your nick:");
        recievePageTitle(driver);
        recieveCookies(driver);
    }

    @Test
    public void testLoginUnExistingUser() throws Exception {
        MainPage main2 = new MainPage(driver);

        goToUrl(driver, "https://beta.pokermatch.com/en#login");
        sendKeysWebElements(main2.fieldEmailLogin,"unexistin",main2.fieldPassword,"111111");
        clickButton(main2.buttonSignIn);
        waitElementPresent(driver,4000,main2.errorMessageLogin);
        Assert.assertEquals(main2.errorMessageLogin.getText(),"Wrong username or password");
    }

/*
    @Test
    public void testRegistrationNewUser(){
        MainPageRegistrationForm registration = new MainPageRegistrationForm(driver);

        goToUrl(driver,"https://beta.pokermatch.com/en#registration");
        registration.fillRegistrarionForm("test_u_13@ukr.net","test_u_13", "111111","1111");
        registration.buttonSignUpRegistration.click();
        waitElementPresent(driver, 4000, mainPage.confirmRegistrationPopUp);
        Assert.assertEquals(mainPage.confirmRegistrationPopUp.getText(), "Registration email has been sent, please confirm your registration within 24h");
    }
    */
}
