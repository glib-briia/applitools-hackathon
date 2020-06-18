package ModernTestsV2;

import base.BaseModernTest;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;
import pages.GalleryPage;

/*
 * Exact copy of ModernTestsV1.Task3
 * No code maintenance done
 * */
public class Task3 extends BaseModernTest {

    @Test(testName = "Product Details test")
    public void testCrossDeviceElements() {
        GalleryPage galleryPage = new GalleryPage(driver);
        eyes.open(driver, APPLICATION_NAME, "Task 3", new RectangleSize(800, 600));
        galleryPage.open();
        galleryPage.filter("colors", "Black");
        galleryPage.navigateToProductDetailsPage(1);
        eyes.check(Target.window().fully().withName("Product Details test"));
    }
}
