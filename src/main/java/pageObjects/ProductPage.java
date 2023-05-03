package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage  extends  BasePage{


    @FindBy(css = "#tab-description h2")
    private WebElement prodcutDescription;
   // private WebDriver driver;





    public ProductPage(WebDriver driver) {
        super(driver);
      //  this.driver = driver;
      //  PageFactory.initElements(driver, this);
    }
    public boolean  isProductPage() {
        return prodcutDescription.isDisplayed();
    }
}
