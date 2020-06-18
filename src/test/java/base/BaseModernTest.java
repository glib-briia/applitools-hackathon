package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/*
 * Base tests for 'modern' tests.
 * All modern Applitools tests classes extend this class
 * which initialises driver and Visual Grid runner before and closes after the tests
 *
 * */
public class BaseModernTest {

    protected static final String APPLICATION_NAME = "AppliFashion";

    protected WebDriver driver;
    protected Eyes eyes;
    private VisualGridRunner runner;

    private static void initiateEyes(Eyes eyes, String batchName) {
        // Initialize eyes Configuration
        Configuration config = new Configuration();
        config.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        // create a new batch info instance and set it to the configuration
        config.setBatch(new BatchInfo(batchName));
        // Desktop
        config.addBrowser(1200, 700, BrowserType.CHROME);
        config.addBrowser(1200, 700, BrowserType.FIREFOX);
        config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
        //Tablet
        config.addBrowser(768, 700, BrowserType.CHROME);
        config.addBrowser(768, 700, BrowserType.FIREFOX);
        config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
        //Mobile
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
        // Set the configuration object to eyes
        eyes.setConfiguration(config);
    }

    /*
    * Batch name and concurrency level supplied as parameters from
    * ModernTestsV1.xml and ModernTestsV2.xml TestNG suites
    * */
    @BeforeClass(alwaysRun = true)
    @Parameters(value = {"concurrency", "batch-name"})
    public void setUp(Integer concurrency, String batchName) {
        this.driver = DriverFactory.getDriver("Chrome");
        // Create a runner with concurrency supplied as parameter from suite xml
        runner = new VisualGridRunner(concurrency);
        eyes = new Eyes(runner);
        initiateEyes(eyes, batchName);
    }

    @AfterClass()
    public void tearDown() {
        // Call Close on eyes to let the server know it should display the results
        this.eyes.closeAsync();
        this.driver.quit();
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }
}

