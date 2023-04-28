package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class AddArticleToCardStepdefs {
    WebDriver driver;
    WebDriverManager webDriverManager;

    //Scénario1

    @Given("^je clique sur le lien pour accéder à la page “shop”$")
    public void jAccedeALaPageShop(){
    }


    @When("je vérifie l'affichage de la page “shop”")
    public void jeVerifieLAffichageDeLaPageShop() {

    }

    @Then("la page “shop” s’affiche")
    public void laPageShopSAffiche() {

    }

    @And("la page “shop” contient des articles de vente")
    public void laPageShopContientDesArticlesDeVente() {
    }

    //Scénario2
    @Given("je suis dans la page {string}")
    public void jeSuisDansLaPage(String arg0) {
    }


    @When("je clique sur bouton {string} pour  ajouter  larticle")
    public void jeCliqueSurBoutonPourAjouterLarticle(String arg0) {

    }

    @Then("article est bien ajouté dans le panier")
    public void articleEstBienAjouteDansLePanier() {
    }

    //Scénario3
    @Given("je suis sur la page shop")
    public void jeSuisSurLaPageShop() {

    }

    @When("jai ajouté un article en panier")
    public void jaiAjouteUnArticleEnPanier() {

    }

    @Then("le lien {string} est affiché")
    public void leLienEstAffiche(String arg0) {
    }

    //Scénario4
    @Given("je suis sur la page shop déjà")
    public void jeSuisSurLaPageShopDeja() {
    }

    @When("jai cliqué sur le bouton ADD TO BASKET")
    public void jaiCliqueSurLeBoutonADDTOBASKET() {
    }

    @Then("un bouton “READ MOR”E saffiche")
    public void unBoutonREADMORESaffiche() {
    }

    //Scénario5
    @Given("j’ai ajouté un article dans le panier")
    public void jAiAjouteUnArticleDansLePanier() {
    }

    @When("j’ai cliqué sur le lien “View basket”")
    public void jAiCliqueSurLeLienViewBasket() {
    }

    @Then("je suis redirigé vers la page de panier")
    public void jeSuisRedirigeVersLaPageDePanier() {
    }

    //Scénario6
    @Given("je suis dans une page de lapplication")
    public void jeSuisDansUnePageDeLapplication() {
    }


    @When("jai ajouté un article dans le panier")
    public void jaiAjouteUnArticleDansLePanier() {

    }

    @And("jai clique sur le lien de licône chariot")
    public void jaiCliqueSurLeLienDeLiconeChariot() {

    }

    @Then("page panier affichée")
    public void pagePanierAffichee() {
    }

    //Scénario7
    @Given("je suis dans la page “shop”")
    public void jeSuisDansLaPageShop() {
    }

    @When("je vérifie l’affichage des articles de vente")
    public void jeVerifieLAffichageDesArticlesDeVente() {

    }
    @Then("affichage des articles avec photo descriptive, libellée et prix affichés au-dessous.")
    public void affichageDesArticlesAvecPhotoDescriptiveLibelleeEtPrixAffichesAuDessous() {
    }


}
