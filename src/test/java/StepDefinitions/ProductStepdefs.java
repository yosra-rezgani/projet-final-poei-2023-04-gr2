package StepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class ProductStepdefs {

    ProductPage productPage;

    public ProductStepdefs(){
        productPage = new ProductPage(Hooks.driver);
    }

    @Then("product page affiché")
    public void productPageAffiché() {
        Assert.assertTrue("la page Prodcut n'est pas affiché", productPage.isProductPage());
    }
}
