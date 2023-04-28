package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAndRegisterPage {

    By registerTitleLocator = By.cssSelector(".u-column1 h2");

    WebDriver driver;


    public LoginAndRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkRegisterIsDisplayed() {
        driver.findElement(registerTitleLocator).isDisplayed();
    }
}
