package ModernTestsV1;

import base.BaseModernTest;
import com.applitools.eyes.RectangleSize;
import org.testng.annotations.Test;
import pages.GalleryPage;

/*
 * Ensure elements are properly hidden or displayed in different viewports and on different browsers.
 * */
public class Task1 extends BaseModernTest {

    @Test(testName = "Cross-Device Elements Test")
    public void testCrossDeviceElements() {
        eyes.open(driver, APPLICATION_NAME, "Task 1", new RectangleSize(VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
        GalleryPage galleryPage = new GalleryPage(driver);
        galleryPage.open();
        eyes.checkWindow("Cross-Device Elements Test");
    }
}
