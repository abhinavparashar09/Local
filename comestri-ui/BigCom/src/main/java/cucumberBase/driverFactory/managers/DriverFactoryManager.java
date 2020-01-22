package cucumberBase.driverFactory.managers;


import cucumberBase.driverFactory.enums.DriverType;
import cucumberBase.driverFactory.enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryManager {

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;


    public DriverFactoryManager() {
        // driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();

        // environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
        driverType = FileReaderManager.getFileReaderManager().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getFileReaderManager().getConfigReader().getEnvironment();
    }

    // To launch driver
    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    // Creating web driver local or remote
    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {

        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    // Selecting local web browser
    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                // System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                // driver = new ChromeDriver();
                return (driver == null) ? driver = new ChromeDriver() : driver;
        }
        return driver;

        // if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
        //   driver.manage().window().maximize();
        //  return driver;
    }


    public void closeDriver() {
        driver.close();
        driver.quit();
    }


}
