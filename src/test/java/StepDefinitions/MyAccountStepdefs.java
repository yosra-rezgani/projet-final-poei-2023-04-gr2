package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.MyAccountPage;

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

      Assert.assertTrue("La création de votre compte n'a pas réussi", accountPage.welcomeTextInMyAccount().contains(successMsg));

    }

    @And("Je saisis mon adresse e-mail {string} et mon mot de passe {string} et Je clique sur le bouton REGISTER")
    public void jeSaisisMonAdresseEMailEtMonMotDePasseEtJeCliqueSurLeBoutonREGISTER(String email, String pwd) {
        accountPage.registerWithStrongPasswordAction(email,pwd);

    }

    @Then("Je reste sur la page d inscription")
    public void jeResteSurLaPageDInscription() {
        Assert.assertTrue(accountPage.checkRegisterIsDisplayed());
    }

    @And("Le bouton <Register> est désactivé")
    public void leBoutonRegisterEstDésactivé() {
        Assert.assertTrue(accountPage.isRegisterBtnDisabled());
    }

    @And("Je vois un message d'erreur qui commence par {string}")
    public void jeVoisUnMessageDErreurQuiCommencePar(String passwordHint) {
        Assert.assertTrue("pas de guide pour la création d'un mot de passe fort", accountPage.passwordHintText().contains(passwordHint));

    }

    @Then("le pavé Login s affiche")
    public void lePavéLoginSAffiche() {
        Assert.assertTrue(accountPage.checkLoginIsDisplayed());
    }

    @When("je me connecte avec le username {string} et le mot de passe {string}")
    public void jeMeConnecteAvecLeUsernameEtLeMotDePasse(String username, String pwd) {
        accountPage.loginAction(username,pwd);
    }


    @Then("l ecran <Dashboard> doit s'afficher")
    public void lEcranDashboardDoitSAfficher() {
        Assert.assertTrue("Vous n'êtes pas dans l'espace 'Dashbbord'", accountPage.welcomeTextInMyAccount().startsWith("Hello"));

    }

    @And("les liens renvoyant aux pages suivantes sont présents : Dashboard, Orders, Download, Adresses, Account Details, Logout")
    public void lesLiensRenvoyantAuxPagesSuivantesSontPrésentsDashboardOrdersDownloadAdressesAccountDetailsLogout() {
        Assert.assertTrue("Au moins un des liens de navigation Dashboard n'existe pas", accountPage.doDashboardNavItemsLinksExist());

    }


    @When("Je renseigne mon adresse e-mail {string} et mon mot de passe {string}")
    public void jeRenseigneMonAdresseEMailEtMonMotDePasse(String email, String pwd) {
        accountPage.registerWithWeakPasswordAction(email,pwd);

    }

    @Then("un message d erreur {string} doit s'afficher")
    public void unMessageDErreurDoitSAfficher(String errorMsg) {

        Assert.assertTrue("Le message d'erreur suite à une tentative de connexion avec mdp erroné n'est pas le bon ", accountPage.loginErrorText().toLowerCase().contains(errorMsg.toLowerCase()));

    }

    @When("je saisie le login {string} et le mot de passe {string}")
    public void jeSaisieLeLoginEtLeMotDePasse(String username, String password) {
        accountPage.setUsernameAndPassword(username,password);
    }
}
