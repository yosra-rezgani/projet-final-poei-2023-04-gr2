package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    @FindBy(css = "li.description_tab.active")
    private WebElement productDescription;
    @FindBy(css = ".woocommerce-message")
    private WebElement messageArticleRemoved;

    @FindBy(xpath = "//a [@class='remove']")
    private WebElement removeArticle;

    static final int TIMEOUT_SIDE_PANEL = 5;
    private final WebDriver driver;



    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void removeArticeFromBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(removeArticle));
        removeArticle.click();
    }

    public boolean articleRemoved() {
        return removeArticle.isDisplayed();
    }

    public String productPageAffiche() {
        return productDescription.getText();

    }
}
