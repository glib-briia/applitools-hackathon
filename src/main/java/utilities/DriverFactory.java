package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/*
* Drivers supplier class.
* WebDriver binaries management is handles by WebDriverManager
* */
public class DriverFactory {

    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    private static final Supplier<WebDriver> edgeDriverSupplier = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    static {
        driverMap.put("Chrome", chromeDriverSupplier);
        driverMap.put("Firefox", firefoxDriverSupplier);
        driverMap.put("Edge", edgeDriverSupplier);
    }

    public static WebDriver getDriver(String browser, String viewport) {
        WebDriver driver = getDriver(browser);
        setViewportSize(driver, viewport);
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver = driverMap.get(browser).get();
        return driver;
    }

    /*
     * Setting window size based on desired viewport.
     *
     * Selenium sets windows size out of the box not the viewport, so
     * we need to calculate windows size that corresponds to desired viewport.
     *
     * window width = window.outerWidth - window.innerWidth  + desired viewport width
     * window height = window.outerHeight - window.innerHeight + desired viewport height
     */
    private static void setViewportSize(WebDriver driver, String viewport) {
        int width = Integer.parseInt(viewport.split(" x ")[0]);
        int height = Integer.parseInt(viewport.split(" x ")[1]);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String windowSize = js.executeScript("return (window.outerWidth - window.innerWidth + " + width + ") + ',' + (window.outerHeight - window.innerHeight + " + height + "); "
        ).toString();
        width = Integer.parseInt(windowSize.split(",")[0]);
        height = Integer.parseInt(windowSize.split(",")[1]);
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
