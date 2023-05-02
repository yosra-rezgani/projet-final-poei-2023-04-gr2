package StepDefinitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.*;

public class ArticleDetailsStepdefs {
    HomePage homePage;
    ShopPage shopPage;
    MyAccountPage accountPage;
    ProductPage productPage ;
    BasketPage basketPage;
    String urlApp = "https://practice.automationtesting.in/";
    String urlShop = "https://practice.automationtesting.in/shop";

    @Given("^je suis sur la page shop")
    public void jesuissurlapageShop(){
        Hooks.driver.get(urlShop);
    };

    @When("je vérifie que le bouton ADD TO BASKET est visible sur la page")
    public void jeVérifieQueLeBoutonADDTOBASKETEstVisibleSurLaPage() {
        shopPage.addToBasketIsDisplay();
    }
    @And("je clique sur le bouton ADD TO BASKET")
    public void jeCliqueSurLeBoutonADDTOBASKET() {
        shopPage.addArticleToBasket();
    }

    @Then("Article ajouté dans le panier")
    public void articleAjoutéDansLePanier() {
        shopPage.viewBasketLinkIsDisplayed();
    }


    @When("je vérifie l existence dun champ indique la quantité en dessous de l’article")
    public void jeVerifieLExistenceDunChampIndiqueLaQuantiteEnDessousDeLArticle() {
        basketPage.quantityFieldVerify();
    }

    @Then("quantité affiché")
    public void AfficheQuantite() {
        basketPage.afficheQuantity();

    }

    @When("je clique sur ADD TO BASKET")
    public void jeCliqueSurADDTOBASKET() {
        shopPage.addArticleToBasket();
    }

    @Then("le message libellé {string} est affiché")
    public void leMessageLibelleEstAffiche(String arg0) {
    }

    @And("je modifie la quantité à 2")
    public void jeModifieLaQuantiteA(int arg0) {
        basketPage.updateQuantity( 2);
    }


    @Then("quantité modifié")
    public void quantiteModifie() {
        basketPage.afficheQuantity();
    }
}

