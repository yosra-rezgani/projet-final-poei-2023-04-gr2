package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {

    @FindBy(css = "[name=register]")
    private WebElement registerBtn;

    @FindBy(id = "reg_email")
    private WebElement username;

    @FindBy(id = "reg_password")
    private WebElement password;

    //Locating Login Button
    @FindBy(css = ".u-column1 h2")
    private WebElement registerTitle;

    @FindBy(css = ".current-menu-item a")
    private WebElement myAccountItem;

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElement welcomeText;

    @FindBy(css = ".woocommerce-password-strength.strong")
    private WebElement strenthPwdInformation;


    private WebDriver driver;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean checkRegisterIsDisplayed() {
       return registerTitle.isDisplayed();
    }

    //Method that performs register action using the web elements
    public void registerAction(String username, String pwd){
        this.username.sendKeys(username);
        this.password.sendKeys(pwd);
        this.password.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(strenthPwdInformation));
        registerBtn.click();
    }

    public String isMyAccountTheCurrentItem(){

        return myAccountItem.getText();
    }

    public String welcomeTextAfterRegister(){
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }
}
