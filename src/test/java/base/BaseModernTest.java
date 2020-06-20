package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.DriverFactory;

/*
 * Base tests for 'modern' tests.
 * All modern Applitools tests classes extend this class
 * which initialises driver and Visual Grid runner before and closes after the tests
 *
 * */
public class BaseModernTest {

    protected static final String APPLICATION_NAME = "AppliFashion";
    private static final int VIEWPORT_WIDTH = 800;
    private static final int VIEWPORT_HEIGHT = 600;
    private static VisualGridRunner runner;
    private static Configuration eyesConfig;
    protected WebDriver driver;
    protected Eyes eyes;

    /*
     * Batch name and concurrency level supplied as parameters from
     * ModernTestsV1.xml and ModernTestsV2.xml TestNG suites
     * */
    @BeforeSuite(alwaysRun = true)
    @Parameters(value = {"concurrency", "batch-name"})
    public void configureEyes(Integer concurrency, String batchName) {
        // Create a runner with concurrency supplied as parameter from suite xml
        runner = new VisualGridRunner(concurrency);
        eyesConfig = new Configuration();
        eyesConfig.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        // create a new batch info instance and set it to the configuration
        eyesConfig.setBatch(new BatchInfo(batchName));
        // Desktop
        eyesConfig.addBrowser(1200, 700, BrowserType.CHROME);
        eyesConfig.addBrowser(1200, 700, BrowserType.FIREFOX);
        eyesConfig.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
        //Tablet
        eyesConfig.addBrowser(768, 700, BrowserType.CHROME);
        eyesConfig.addBrowser(768, 700, BrowserType.FIREFOX);
        eyesConfig.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
        //Mobile
        eyesConfig.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
    }

    /*
     * Batch name and concurrency level supplied as parameters from
     * ModernTestsV1.xml and ModernTestsV2.xml TestNG suites
     * */
    @BeforeClass(alwaysRun = true)
    public void initialiseEyes() {
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getDriver("Chrome");
        eyes = new Eyes(runner);
        eyes.setConfiguration(eyesConfig);
    }


    @AfterSuite(alwaysRun = true)
    public void retrieveResults() {
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        for (TestResultContainer resultContainer : allTestResults.getAllResults()) {
            System.out.println(resultContainer.getTestResults());
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeEyes() {
        // Call Close on eyes to let the server know it should display the results
        eyes.closeAsync();
        driver.quit();
    }
}

