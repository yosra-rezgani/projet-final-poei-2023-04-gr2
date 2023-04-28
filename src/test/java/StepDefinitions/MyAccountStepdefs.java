package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

import java.time.Duration;

public class MyAccountStepdefs {
    MyAccountPage accountPage;

    public MyAccountStepdefs(){
        accountPage = new MyAccountPage(Hooks.driver);
    }
    @Then("le pavé Register s affiche")
    public void lePavéRegisterSAffiche() {

        Assert.assertTrue(accountPage.checkRegisterIsDisplayed());

    }



    @Then("Je suis redirigé vers la page My Account")
    public void jeSuisRedirigéVersLaPageMyAccount() {

        Assert.assertEquals("La page actuelle n'est pas 'My Account'", "My Account", accountPage.isMyAccountTheCurrentItem() );
    }

    @And("Je vois le message de confirmation {string}")
    public void jeVoisLeMessageDeConfirmation(String successMsg) {

      Assert.assertTrue("La création de votre compte n'a pas réussi", accountPage.welcomeTextAfterRegister().contains(successMsg));

    }

    @And("Je saisis mon adresse e-mail {string} et mon mot de passe {string} et Je clique sur le bouton REGISTER")
    public void jeSaisisMonAdresseEMailEtMonMotDePasseEtJeCliqueSurLeBoutonREGISTER(String email, String pwd) {
        accountPage.registerAction(email,pwd);

    }
}
