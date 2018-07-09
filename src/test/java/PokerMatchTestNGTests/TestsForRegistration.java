package PokerMatchTestNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static PokerMatchTestNGTests.WebLibrary.cleanCash;
import static PokerMatchTestNGTests.WebLibrary.goToUrl;

public class TestsForRegistration {
    public WebDriver driver;

    @BeforeClass
    public void beforAll(){
        System.setProperty("webdriver.gecko.driver", "H://Geckodriver_FireFox//geckodriver.exe");
        cleanCash();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void shutDown(){

        driver.quit();
    }
    @Test
    public void testRegistrationNewUser(){
        MainPageRegistrationForm registration = new MainPageRegistrationForm(driver);
        MainPage mainPage = new MainPage(driver);

        goToUrl(driver,"https://beta.pokermatch.com/en#registration");
        registration.fillRegistrarionForm("test_u_15@ukr.net","test_u_15", "111111","1111");
        registration.buttonSignUpRegistration.click();
        Assert.assertEquals(mainPage.confirmRegistrationPopUp.getText(), "Registration email has been sent, please confirm your registration within 24h");
    }

}
