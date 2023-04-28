package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    By myAccountLocator = By.cssSelector("#main-nav li:nth-child(2)");
    By btnCloseGoogleAdLocator = By.id("dismiss-button");
    By iFrameLocator = By.cssSelector("[name=aswift_7]");

  //  By iFrameLocator2 = By.cssSelector("[name=ad_iframe]");
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage(){
        driver.findElement(myAccountLocator).click();
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(btnCloseGoogleAdLocator)).click();


    }
    public void closeGoogleAds(){

        WebElement iFrame = driver.findElement(iFrameLocator);
       // WebElement iFrame2 = driver.findElement(iFrameLocator2);
        driver.switchTo().frame(iFrame);
                //.switchTo().frame(iFrame2);
        driver.findElement(btnCloseGoogleAdLocator).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().defaultContent();

    }
}
