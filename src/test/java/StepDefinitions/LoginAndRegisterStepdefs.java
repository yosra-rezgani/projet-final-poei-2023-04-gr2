package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePage;
import pageObjects.LoginAndRegisterPage;

public class LoginAndRegisterStepdefs {
    String url = "https://practice.automationtesting.in/";

    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;

    @Given("J ouvre l application")
    public void jOuvreLApplication() {
        /*
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Hooks.driver.get("https://practice.automationtesting.in/");
        */
        Hooks.driver.get(url);
    }


    @When("Je vais dans l espace <My account>")
    public void jeVaisDansLEspaceMyAccount() {
        homePage = new HomePage(Hooks.driver);
        homePage.goToLoginPage();
        homePage.closeGoogleAds();
    }



    @Then("Le pavé <Register> s affiche")
    public void lePavéRegisterSAffiche() {
        loginAndRegisterPage = new LoginAndRegisterPage(Hooks.driver);
        loginAndRegisterPage.checkRegisterIsDisplayed();
    }
}
