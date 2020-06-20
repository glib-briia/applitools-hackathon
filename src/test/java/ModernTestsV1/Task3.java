package ModernTestsV1;

import base.BaseModernTest;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;
import pages.GalleryPage;

/*
 * Click on the first Black shoe to navigate to its details page. Check if everything looks good and accurate.
 * */
public class Task3 extends BaseModernTest {

    @Test(testName = "Product Details test")
    public void testCrossDeviceElements() {
        eyes.open(driver, APPLICATION_NAME, "Task 3", new RectangleSize(VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
        GalleryPage galleryPage = new GalleryPage(driver);
        galleryPage.open();
        galleryPage.filter("colors", "Black");
        galleryPage.navigateToProductDetailsPage(1);
        eyes.check(Target.window().fully().withName("Product Details test"));
    }
}
