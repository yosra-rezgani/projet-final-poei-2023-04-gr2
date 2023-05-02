package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage {




    @FindBy(css = ".checkout-button.button.alt.wc-forward']")
    private WebElement checkOUtBtn;

    @FindBy(css = ".woocommerce li")
    private WebElement messageErrorCoupon;
    @FindBy(xpath = "//input[@name='coupon_code']")
    private WebElement couponcode;

    @FindBy(xpath = "//input[@name='apply_coupon']")
    private WebElement btnCouponCode;
    @FindBy(xpath = "//a [@class='remove']")
    private WebElement removeArticle;

    @FindBy(xpath = "//input[@name='update_cart']")
    private WebElement clickButtonUpdate;
    @FindBy(css = "#page-34 th:nth-child(5)")
    private WebElement quantityFieldDisplay;

    @FindBy(css = "#page-34 th:nth-child(3)")
    private WebElement libelleeFieldDisplay;

    @FindBy(css = "#page-34 th:nth-child(4)")
    private WebElement priceFieldDisplay;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    private WebElement quantityField;

    private  WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean quantityFieldVerify() {
        return quantityFieldDisplay.isDisplayed();
    }

    public boolean afficheQuantity() {
        return quantityField.isDisplayed();
    }

    public BasketPage updateQuantity(int newQuantity) {
        WebElement quantitySelectTag = (WebElement) driver.findElements(By.xpath("//input[@class='input-text qty text']"));
        Select dropdownQuantity = new Select(quantitySelectTag);
        dropdownQuantity.selectByIndex(newQuantity);
        return this;
    }

    public boolean recapOrder() {
        return  quantityFieldDisplay.isDisplayed() &&
                libelleeFieldDisplay.isDisplayed() &&
                priceFieldDisplay.isDisplayed();
    }
    public boolean removeXisDisplayed() {
        return  removeArticle.isDisplayed();
    }

    public void clickUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(clickButtonUpdate));
        clickButtonUpdate.click();

    }

    public boolean couponCodeIsDisplayed() {
        return couponcode.isDisplayed();
    }

    public void applyreductioncoupon(String coupon){
        this.couponcode.sendKeys(coupon);
}

    public void clickApplyCoupon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(btnCouponCode));
        btnCouponCode.click();
    }

    public String messageErrorIsDisplayed() {

        return this.messageErrorCoupon.getText();
    }

    public void ClickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(checkOUtBtn));
        checkOUtBtn.click();

    }


}


