package thirdclass.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTestGoogleSearch {
    public WebDriver driver;

    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "H://Geckodriver_Chrome//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }
    @Test
    public void testBasePage(){

        String baseURL = "http://www.google.com";
        driver.get(baseURL);
        WebElement actualGoogleImage = driver.findElement(By.id("hplogo"));
        Assert.assertEquals(actualGoogleImage, driver.findElement(By.id("hplogo")));
        System.out.println("Page element is: " + driver.findElement(By.id("hplogo")));

    }

    @AfterClass
    public void shutDown(){

        driver.quit();
    }
}
