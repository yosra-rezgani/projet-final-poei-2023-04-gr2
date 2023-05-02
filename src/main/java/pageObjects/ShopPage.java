package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    @FindBy(css = "[data-product_id='165']")
    private WebElement addToBasketBtn;

    @FindBy(id = "wpmenucartli")
    private WebElement iconeCart;
    @FindBy(css = ".post-165 .added_to_cart")
    private WebElement viewBasketLink;

    @FindBy(id = "menu-item-40")
    private WebElement shopItemInMenu;

    @FindBy(css = ".post-169")
    private WebElement anOutOfStockArticle;

    @FindBy(css = ".post-169 a.ajax_add_to_cart")
    private WebElement readMoreBtn;


    @FindBy(css = ".stock.out-of-stock")
    private WebElement outOfStockTag;

    @FindBy(css = "#content .woocommerce-breadcrumb a")
    private WebElement homeTitleInShop;


    @FindBy(css = ".u-column2 h2")
    private WebElement shopTitle;
    @FindBy(css = ".cart_totals h2")
    private WebElement totalProductBasket;
    @FindBy(id = "#page-34 th:nth-child(6)")
    private WebElement firstItemActual;

    @FindBy(xpath = "//span[text()='250.00']")
    private WebElement priceArticle;

    @FindBy(xpath = "//a[h3='Android Quick Start Guide']")
    private WebElement libelleeArticle;

    @FindBy(xpath = "//img[@alt='Functional Programming in JS']")
    private WebElement imageArticle;

    @FindBy(css = ".cartcontents")
    private WebElement cardPage;

    @FindBy(id = "#text-3")
    private WebElement filterPrice;

    private  WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickshop (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(shopItemInMenu));
        shopItemInMenu.click();
        new Actions(driver).moveByOffset(10, 10).click().build().perform();
        driver.switchTo().defaultContent();

    }

    public void addArticleToBasket(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketBtn)).click();
    }

    public void clickOnViewBasket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketBtn)).click();

    }

    public boolean  checkShopPageIsDisplayed() {
       return homeTitleInShop.isDisplayed();
    }

    public boolean viewBasketLinkIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return   wait.until(ExpectedConditions.visibilityOf(viewBasketLink)).isDisplayed();

    }


    public void clickOnOutOfStockProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(anOutOfStockArticle)).click();

    }
    public boolean outOfStockIsDisplayed() {
        return outOfStockTag.isDisplayed();
    }

   public boolean isReaDMoreDisplayed(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       return wait.until(ExpectedConditions.visibilityOf(readMoreBtn)).isDisplayed();

   }

    public boolean checkBasketIsDisplayed() {
     return totalProductBasket.isDisplayed();}

    public boolean checkFirstitem(){
        return firstItemActual.isDisplayed();
    }


    public boolean priceArticleIsdisplay(){
        return priceArticle.isDisplayed();
    }
    public boolean ArticleOptionLinks(){
        return libelleeArticle.isDisplayed() &&
                priceArticle.isDisplayed() &&
                imageArticle.isDisplayed() ;
    }

    public void jeCliqueSurlibellee() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(libelleeArticle));
        libelleeArticle.click();
    }

    public void clickcartcontents() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cardPage));
        cardPage.click();
    }

    public void filtrePrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(filterPrice));
        filterPrice.click();
    }

    public boolean filtrePriceisDisplay() {
        return filterPrice.isDisplayed();
    }

    public boolean addToBasketIsDisplay() {
            return addToBasketBtn.isDisplayed();
    }

    public void clickOnCartIcon(){
        iconeCart.click();
    }
}
