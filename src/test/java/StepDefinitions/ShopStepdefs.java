package StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShopPage;

public class ShopStepdefs {

    ShopPage shopPage;
    HomePage homePage;
    ProductPage productPage;
    public ShopStepdefs(){
        homePage = new HomePage(Hooks.driver);
        shopPage  = new ShopPage(Hooks.driver);
        productPage = new ProductPage(Hooks.driver);
    }

    @When("je clique sur le lien pour accéder à la page <shop>")
    public void jeCliqueSurLeLienPourAccéderÀLaPageShop() {
        shopPage.clickshop();

    }
    @When("je clique sur bouton Add to basket pour  ajouter  larticle")
    public void jeCliqueSurBoutonPourAjouterLarticle() {
        shopPage.addArticleToBasket();
    }

    @Then("un bouton <READ MORE> saffiche en dessous de l'article")
    public void unBoutonREADMORESafficheEnDessousDeLArticle() {
        Assert.assertTrue("Le bouton READ MORE n'est pas affiché", shopPage.isReaDMoreDisplayed());
    }

    @Then("le lien VIEW BASKET s'affiche")
    public void leLienVIEWBASKETSAffiche() {
        Assert.assertTrue("Le lien VIEW BASKET n'est pas visible",shopPage.viewBasketLinkIsDisplayed());
    }

    @When("je clique sur l article")
    public void jeCliqueSurLArticle() {
        shopPage.clickOnOutOfStockProduct();
    }
    @Then("l article est en rupture")
    public void lArticleEstEnRupture() {

        Assert.assertTrue("Le bouton READ MORE n'est pas affiché",  shopPage.outOfStockIsDisplayed());
    }
    @When("je clique sur l'icone chariot")
    public void jeCliqueSurLIconeChariot() {

        shopPage.clickOnCartIcon();
    }

    @Then("je suis redirigé vers la page de panier")
    public void jeSuisRedirigéVersLaPageDePanier() {
        Assert.assertEquals("La page actuelle n'est pas Panier", "Basket Totals",shopPage.checkBasketIsDisplayed() );
    }



    @Then("la page <shop> s'affiche et contient des articles de vente")
    public void laPageShopSAfficheEtContientDesArticlesDeVente() {
    Assert.assertTrue("La page Shop ne s'affiche pas ",shopPage.checkShopPageIsDisplayed());
    }


    @Then("affichage des articles avec photo descriptive, libellée et prix affichés au-dessous")
    public void affichageDesArticlesAvecPhotoDescriptiveLibelléeEtPrixAffichésAuDessous() {
        Assert.assertTrue("Les articles en contiennent pas tous une image, un libellé et un prix", shopPage.isProductListingGood());
    }
}
