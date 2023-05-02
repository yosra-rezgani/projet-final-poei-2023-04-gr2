package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.BasketPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;
import pageObjects.ShopPage;

public class CheckPanierStepdefs {
    MyAccountPage myacountPage;
    ShopPage shopPage;
    BasketPage basketPage;
    ProductPage productPage;
    String urlApp = "https://practice.automationtesting.in/";

    @Given("j ouvre l application")
    public void jouvrelapplication(){
        Hooks.driver.get(urlApp);
    };

    @And("je suis sur la page {string}")
    public void jeSuisSurLaPage(String arg0) {
        shopPage.clickshop();

    }

    @When("je clique sur le bouton {string} en dessous de l'ouvrage {string}")
    public void jeCliqueSurLeBoutonEnDessousDeLOuvrage() {
            shopPage.addArticleToBasket();
        }

    @Then("un lien {string} s'affiche")
    public void unLienSAffiche(String arg0) {
        shopPage.viewBasketLinkIsDisplayed();
    }

    @And("j ai ajouté à mon panier l'ouvrage {string} de la page shop")
    public void jAiAjouteAMonPanierLOuvrageDeLaPageShop(String arg0) {
        shopPage.addArticleToBasket();
    }


    @When("je clique sur le logo panier en haut de la page")
    public void jeCliqueSurLeLogoPanierEnHautDeLaPage() {
        shopPage.clickOnViewBasket();
        
    }

    @Then("un récapitulatif de la commande s{string}ouvrage, le prix unitaire, la quantité et le prix total")
    public void unRécapitulatifDeLaCommandeSAffichePrésentantLeLibelléDeLOuvrageLePrixUnitaireLaQuantitéEtLePrixTotal() {
        basketPage.recapOrder();
    }

    @And("jai ajouté louvrage Mastering JavaScript à partir de la page panier")
    public void jaiAjoutéLouvrageMasteringJavaScriptÀPartirDeLaPagePanier() {
        shopPage.addArticleToBasket();
    }

    @And("je clique sur view basket")
    public void jecliquesurViewbasket() {
        shopPage.clickOnViewBasket();
    }

    @When("une croix X est présente à droite de l'article")
    public void uneCroixXEstPrésenteÀDroiteDeLArticle() {
        basketPage.removeXisDisplayed();
    }

    @And("je clique sur X")
    public void jeCliqueSurX() {
        productPage.removeArticeFromBasket();
    }

    @Then("larticle est supprimé de mon panier")
    public void larticleEstSuppriméDeMonPanier() {
    productPage.articleRemoved();
        
    }

    @Given("je me suis connecté à l'application")
    public void jeMeSuisConnectéÀLApplication(String email, String pwd) {
        myacountPage.loginAction(email,pwd);;
    }

    @And("j ai ajouté l ouvrage {string} au panier")
    public void jAiAjoutéLOuvrageAuPanier(String arg0) {
        shopPage.addArticleToBasket();
    }

    @When("je clique sur je clique sur view Basket")
    public void jeCliqueSur() {
        shopPage.clickOnViewBasket();
        
    }

    @And("je modifie la quantité de mon article de {int} à {int} dans la case {string}")
    public void jeModifieLaQuantitéDeMonArticleDeÀDansLaCase(int newQuantity) {
        basketPage.updateQuantity(newQuantity);
    }

    @Then("je clique sur le bouton Update Basket")
    public void jeCliqueSurLeBoutonUpdateBasket() {
        basketPage.clickUpdate();
    }

    @And("j ai ajouter un ouvrage dans mon panier")
    public void jAiAjouterUnOuvrageDansMonPanier() {
        shopPage.addArticleToBasket();
    }


    @Then("un champs coupons code et un boutton apply s affichent")
    public void unChampsEtUnBouttonSAffichent() {
        basketPage.couponCodeIsDisplayed();
    }

    @And("je saisie un coupon {string} de reduction")
    public void jeSaisieUnCouponDeReduction(String coupon) {
        basketPage.applyreductioncoupon(coupon);
    }

    @Then("je clique sur Apply Coupon")
    public void jeCliqueSurApplyCoupon() {
        basketPage.clickApplyCoupon();
    }

    @Then("le pavé recapitulatif {string} s'affiche")
    public void lePavéRecapitulatifSAffiche() {
        basketPage.recapOrder();
    }

    @Then("je clique sur  bouton {string} pour valider la commande")
    public void jeCliqueSurBoutonPourValiderLaCommande() {
        basketPage.ClickCheckout();
    }

    @And("un message coupon invalide est affiché  {string}")
    public void unMessageCouponInvalideEstAffiche(String message) {
      String actualMsg =  basketPage.messageErrorIsDisplayed();
        Assert.assertEquals("Coupon promo30 does not exist!", message, actualMsg );
    }


}

