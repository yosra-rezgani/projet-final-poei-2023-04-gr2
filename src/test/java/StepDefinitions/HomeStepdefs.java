package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class HomeStepdefs {

    String url = "https://practice.automationtesting.in/";
   // private WebDriver driver;
    HomePage homePage;

    public HomeStepdefs(){
        homePage = new HomePage(Hooks.driver);
    }
    @Given("J ouvre l application")
    public void jOuvreLApplication() {
        Hooks.driver.get(url);
    }

    @When("Je vais dans l espace My account")
    public void jeVaisDansLEspaceMyAccount() {
        Hooks.driver.get(url);

        homePage.goToLoginPage();
        homePage.closeGoogleAds();
    }

    @Given("Je suis sur le pavé Register")
    public void jeSuisSurLePavéRegister() {
        Hooks.driver.get(url);

        homePage.goToLoginPage();
        homePage.closeGoogleAds();

    }
}
