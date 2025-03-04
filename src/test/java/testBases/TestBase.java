package testBases;

import dataReader.Load_Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import static model.CustomWebDriver.initDriver;


public abstract class TestBase {

    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*****************************/
    protected WebDriver driver;
//    protected static ThreadLocal<WebDriver> driver_Thread = new ThreadLocal<>();
    /**************************************GLOBAL_VARIABLES***********************************************/
    private final String amazon_URL = Load_Properties.environment_Data.getProperty("amazon_URL");
    private final String browser = Load_Properties.environment_Data.getProperty("browser");

    /******************************************METHODS**************************************************/

    @Parameters({"browser"})
    @BeforeMethod(groups = {"Regression"})
    public void setUp_Environment()
    {

        switch (browser)
        {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            case "ChromeHeadless" -> {ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
//            options.addArguments("--window-size = 1920,1080");
                driver = new ChromeDriver(options);}
            default -> driver = new ChromeDriver();
        }
        driver.get(amazon_URL);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.navigate().refresh();
    }

}

