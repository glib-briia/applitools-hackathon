package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.DriverFactory;

/*
* Base tests for 'traditional' tests.
* All traditional tests classes extend this class
* which initialises driver before and closes after the tests
*
* */
public class BaseTraditionalTest {

    /* Tests groups */
    protected static final String Laptop = "Laptop";
    protected static final String Tablet = "Tablet";
    protected static final String iPhone_X = "iPhone X";

    protected WebDriver driver;

    /*
    * Parameters supplied from
    * TraditionalTestsV1.xml, TraditionalTestsV2.xml TestNG suites
    * */
    @BeforeClass(alwaysRun = true)
    @Parameters(value = {"device", "browser", "viewport"})
    public void setUp(String device, String browser, String viewport) {
        this.driver = DriverFactory.getDriver(browser, viewport);
    }

    @AfterClass(groups = {"Laptop", "Tablet", "iPhone X"})
    public void tearDown() {
        this.driver.quit();
    }
}

