package PokermatchTestNGTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static PokermatchTestNGTests.WebLibrary.*;

public class TestsForSignIn {

    public static WebDriver driver = null;

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

        goToUrl(driver, "https://beta.pokermatch.com");
        clickButton(main.buttonLoginBeta);
        sendKeysWebElements(main.fieldEmailLogin,"test_bibik",main.fieldPassword,"111111");
        clickButton(main.buttonSignIn);
        Assert.assertEquals(main.elementNickName.getText(),"Your nick:");
        clickButton(main.buttonLogOutBeta);
    }

    @Test(priority=2)
    public void testLoginUnExistingUser() throws Exception {
        MainPage main2 = new MainPage(driver);

        goToUrl(driver, "https://beta.pokermatch.com");
        clickButton(main2.buttonLoginBeta);
        sendKeysWebElements(main2.fieldEmailLogin,"unexistin",main2.fieldPassword,"111111");
        clickButton(main2.buttonSignIn);
        Assert.assertEquals(main2.errorMessageLogin.getText(),"Wrong username or password");
    }

    @Test(priority=3)
    public void testLoginEmptyFields(){
        MainPage main3 = new MainPage(driver);

        goToUrl(driver,"https://beta.pokermatch.com");
        clickButton(main3.buttonLoginBeta);
        clearTextField(main3.fieldEmailLogin);
        clearTextField(main3.fieldPassword);
        clickButton(main3.buttonSignIn);
        Assert.assertEquals(main3.errorMessageLogin.getText(),"Wrong username or password");
    }

    @Test(priority = 4)
    public void testLoginAsExistingUser(){
        MainPage main4 = new MainPage(driver);

        driver.get("https://beta.pokermatch.com");
        main4.buttonLoginBeta.click();
        main4.fillLoginForm("test_bibik","111111");
        main4.buttonSignIn.click();
        Assert.assertEquals(main4.elementNickName.getText(),"Your nick:");
        main4.buttonLogOutBeta.click();
    }

}
