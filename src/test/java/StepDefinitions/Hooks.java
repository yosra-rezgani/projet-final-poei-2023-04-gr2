package StepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().cachePath("C:/dev").avoidOutputTree().setup();
        //actualiser la version de mon driver
        /**
         * Ajouter arguments -> Options : Car, on utilise version 4.4.0 de selenium (ancienne version)
         * Dernières version de Selenium (4.8.3) n'ont pas besoin de leur rajouter des arguments
         */
        ChromeOptions options = new ChromeOptions(); //activer le driver chrome
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        driver.quit();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, KeyManagementException {
        ImportResultToXray importResultToXray = new ImportResultToXray();
        importResultToXray.getToken();
    }
}
