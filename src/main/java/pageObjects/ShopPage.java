package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage extends  BasePage{


    @FindBy(css = ".post-169")
    private WebElement firstProduct;

    /*
    @FindBy(css = ".post-165")
    private WebElement anAvailableProduct;
     */
    @FindBy(css = ".post-165 .add_to_cart_button")
    private WebElement addToCartBtn;

    @FindBy(css = ".post-165 .added_to_cart")
    private WebElement viewBasket;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void goToFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
    }

    public void addProductToCartAndViewBasket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(viewBasket));
        viewBasket.click();
    }



}
