package Pokermatch.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageRegistrationForm extends MainPage{

    public MainPageRegistrationForm (WebDriver driver){
        super(driver);
    }

    /*
    public MainPageRegistrationForm(WebElement fieldEmailRegistration, WebElement fieldLoginRegistration, WebElement fieldPasswordRegistration, WebElement fieldCapchaRegistration){
        this.fieldEmailRegistration = fieldEmailRegistration;
        this.fieldLoginRegistration = fieldLoginRegistration;
        this.fieldPasswordRegistration = fieldPasswordRegistration;
        this.fieldCapchaRegistration = fieldCapchaRegistration;
    }
    */

    // Registration form pop-up
    @FindBy(xpath = "//div[@id='registration']//input[@name='email']")
    public WebElement fieldEmailRegistration;
    @FindBy(id = "login")
    public WebElement fieldLoginRegistration;
    @FindBy(xpath = "//div[@class='modala__field modala__field_password']//input[@class='modala__input password_control']")
    public WebElement fieldPasswordRegistration;
    @FindBy(xpath = "")
    public WebElement radiobuttonUAH_Registration;
    @FindBy(xpath = "")
    public WebElement radiobuttonUSD_Registration;
    @FindBy(xpath = "")
    public WebElement radiobuttonEUR_Registration;
    @FindBy(xpath = "")
    public WebElement checkBoxIAgreeWithTermsAndConditions_Registration;
    @FindBy(xpath = "")
    public WebElement checkBoxIAgreeToRecieveEmailSMS_Registration;
    @FindBy(xpath = "//div[@id='registration']//input[@class='modala__input modala__input_captcha']")
    public WebElement fieldCapchaRegistration;
    @FindBy(xpath = "//div[@id='registration']//button[@class='modala-button']")
    public WebElement buttonSignUpRegistration;

    public void fillRegistrarionForm(String email, String login, String password, String capcha){
        fieldEmailRegistration.clear();
        fieldEmailRegistration.sendKeys(email);
        fieldLoginRegistration.clear();
        fieldLoginRegistration.sendKeys(login);
        fieldPasswordRegistration.clear();
        fieldPasswordRegistration.sendKeys(password);
        fieldCapchaRegistration.clear();
        fieldCapchaRegistration.sendKeys(capcha);

    }
}
