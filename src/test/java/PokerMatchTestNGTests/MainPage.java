package PokerMatchTestNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // Main page buttons Login/Registration/Language bar/Confirm ragistration pop up in header
    @FindBy (xpath = "//a[@href='#login']")
    public WebElement buttonLoginBeta;
    @FindBy (xpath = "/html/body/div[3]/section/article/div/div[2]/a[2]/span/span")
    public WebElement buttonLogOutBeta;
    //@FindBy (xpath = "//div[@class='head__col']//a[@href='#login']")
    //public WebElement buttonLoginProd;
    @FindBy(xpath = "//div[@class='head__inner']//a[@href='#registration']")
    public WebElement buttonRegistrationBeta;
    @FindBy (id = "languages")
    public WebElement dropdouwnLanguages;
    @FindBy (xpath = "//div[@class='user_notice_hint_wrapper event_message_wrapper']//div[@class='event_message']")
    public WebElement confirmRegistrationPopUp;

    // Login form pop-up
    @FindBy(xpath = "//div[@class='modala__body']//input[@name='login']")
    public WebElement fieldEmailLogin;
    @FindBy(xpath = "//div[@class='modala__body']//input[@class='modala__input password_control'][@tabindex='2']")
    public WebElement fieldPassword;
    @FindBy(xpath = "//div[@class='modala__body']//a[@class='modala__link']")
    public WebElement linkRemaindPassword;
    @FindBy(xpath = "//div[@class='modala-submit']/button[@class='modala-button']")
    public WebElement buttonSignIn;
    @FindBy (xpath = "//div[@class='modala__field modala__field_password']//div[1]")
    public WebElement errorMessageLogin;


    // Main page header elements
    @FindBy(xpath = "//div[@class='top_menu__inner']//a[@href='https://beta.pokermatch.com/en/news']")
    public WebElement buttonkNews;
    @FindBy(xpath = "div[@class='top_menu__inner']//a[@href='https://beta.pokermatch.com/en/tutorial']")
    public WebElement buttonHowToPlay;
    @FindBy(xpath = "//div[@class='top_menu__inner']//a[@href='https://beta.pokermatch.com/en/promo']']")
    public WebElement buttonPromo;
    @FindBy(xpath = "//div[@class='top_menu__inner']//a[@href='https://beta.pokermatch.com/en/about']")
    public WebElement buttonAbout;
    @FindBy(xpath = "//div[@class='top_menu__inner']//a[@href='https://beta.pokermatch.com/en/pages']")
    public WebElement buttonInformation;

    // Google page
    @FindBy(xpath = "//input[contains(@class,'gsfi lst-d-f')]")
    public WebElement fieldSearchOnGooglePage;
    @FindBy(xpath = "//div[@class='tsf-p']//input[@name='btnK']")
    public WebElement buttonSearchOnGooglePage;

    // Main page after autorization - NickName for current player
    @FindBy (xpath = "//div[@class='info-list__item info-list__item_type_nick']//span[@class='info-list__item-label']")
    public WebElement elementNickName;

    // Beta pokerdom main page elements
    @FindBy(xpath = "//a[contains(@href,'#login')]")
    public WebElement butttonLoginBetaPD;

    // GitHub main page elements
    @FindBy (xpath = "//div[@class='d-lg-flex']//a[@href='/login']")
    public WebElement buttonSignInGitHub;
    @FindBy (id = "login_field")
    public WebElement fieldLoginGitHub;
    @FindBy (id = "password")
    public WebElement fieldPasswordGitHub;
    @FindBy (xpath = "//div[@class='auth-form-body mt-3']//input[@class='btn btn-primary btn-block']")
    public WebElement getButtonSignInLoginPopUpGitHub;
    @FindBy (xpath = "//div[@class='HeaderMenu d-flex flex-justify-between flex-auto']//a[@data-hotkey='g p']")
    public WebElement linkPullRequests;


    public void fillLoginForm(String login, String password){
        fieldEmailLogin.clear();
        fieldEmailLogin.sendKeys(login);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
    }

    public void sendTextToSearchField(String text){

        fieldSearchOnGooglePage.sendKeys(text);
    }

}
