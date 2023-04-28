package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    @FindBy(css = "#main-nav li:nth-child(2)")
    private WebElement myAccount;

    @FindBy(id = "dismiss-button")
    private WebElement btnCloseGoogleAd;

    @FindBy(css = "[name=aswift_7]")
    private WebElement firstIframeGoogleAd;

    @FindBy(css = "[name=ad_iframe]")
    private WebElement secondIframeGoogleAd;


    private  WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
       myAccount.click();

    }

    public void closeGoogleAds() {

        WebElement iFrame = firstIframeGoogleAd;
        driver.switchTo().frame(iFrame);
        WebElement iFrame2 = secondIframeGoogleAd;

        driver.switchTo().frame(iFrame2);
        btnCloseGoogleAd.click();
        driver.switchTo().defaultContent();

    }
}
