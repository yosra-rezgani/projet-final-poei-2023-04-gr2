package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogoutStepdefs {
    
    @Given("^je suis connecté à mon compte$")
    public void jesuisconnectéàmoncompte(){
    }
    
    @And("je cherche dans la page pour trouver le lien ” logout”")
    public void jeChercheDansLaPagePourTrouverLeLienLogout() {
    }

    @When("je clique sur le lien de “logout”")
    public void jeCliqueSurLeLienDeLogout() {
        
    }

    @Then("je suis déconnecté de mon compte")
    public void jeSuisDeconnecteDeMonCompte() {
        
    }

    @And("je suis  redirigé vers la page daccueil vers les pavé de {string} et de {string}")
    public void jeSuisRedirigeVersLaPageDaccueilVersLesPaveDeEtDe(String arg0, String arg1) {
    }
}
