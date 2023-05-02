package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShopPage;

public class AddToBasketStepdefs {
    ShopPage shopPage;
    HomePage homePage;
    ProductPage productPage;


    public AddToBasketStepdefs(){
        homePage = new HomePage(Hooks.driver);
        shopPage  = new ShopPage(Hooks.driver);
        productPage = new ProductPage(Hooks.driver);
    }

    @When("je vérifie l'affichage de la page “shop”")
    public void jeVérifieLAffichageDeLaPageShop() {

        Assert.assertTrue("La page shop n'est pas affichée",shopPage.checkShopPageIsDisplayed());

    }



    @When("je clique sur bouton Add to basket pour  ajouter  larticle")
    public void jeCliqueSurBoutonPourAjouterLarticle() {
        shopPage.addArticleToBasket();

    }

    @Then("le lien VIEW BASKET s'affiche")
    public void leLienVIEWBASKETSAffiche() {
        Assert.assertTrue("Le lien VIEW BASKET n'est pas visible",shopPage.viewBasketLinkIsDisplayed());
    }



    @And("Article n'est pas dispo en stock")
    public void articleNEstPasDispoEnStock() {
        Assert.assertTrue(shopPage.outOfStockIsDisplayed());
    }



    @When("je clique sur le lien “View basket”")
    public void jeCliqueSurLeLienViewBasket() {
        shopPage.clickOnViewBasket();
    }

    @Then("je suis redirigé vers la page de panier")
    public void jeSuisRedirigéVersLaPageDePanier() {
        Assert.assertTrue("La page actuelle n'est pas Panier", shopPage.checkBasketIsDisplayed());
    }


    @When("je vérifie l’affichage des articles de vente")
    public void jeVérifieLAffichageDesArticlesDeVente() {

/*
        WebElement proposalItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.onsale")));
        String firstItemActual = proposalItem.getText();
        Assert.assertTrue("The first article in 'Page Shop' is not 'Android Quick Start Guide'", firstItemActual.contains(firstItemShopPage));

   */

    }

    @Then("affichage des articles avec photo descriptive, libellée et prix affichés au-dessous")
    public void affichageDesArticlesAvecPhotoDescriptiveLibelléeEtPrixAffichésAuDessous() {
        shopPage.ArticleOptionLinks();
    }

    @When("je clique sur {string} de l'article")
    public void jeCliqueSurDeLArticle() {
        shopPage.jeCliqueSurlibellee();
    }

    @And("je choisis filtrage par prix")
    public void jeChoisisFiltrageParPrix() {
        shopPage.filtrePrice();
    }

    @Then("affichage des articles filtrés par prix")
    public void affichageDesArticlesFiltrésParPrix() {
        shopPage.filtrePriceisDisplay();
    }

    @Then("product page affiché")
    public void productPageAffiche() {
    productPage.productPageAffiche();

    }

    @When("je clique sur le lien pour accéder à la page <shop>")
    public void jeCliqueSurLeLienPourAccéderÀLaPageShop() {
        shopPage.clickshop();
    //   homePage.closeGoogleAds();

    }


    @Then("un bouton <READ MORE> saffiche en dessous de l'article")
    public void unBoutonREADMORESafficheEnDessousDeLArticle() {
     Assert.assertTrue("Le bouton READ MORE n'est pas affiché", shopPage.isReaDMoreDisplayed());
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
}
