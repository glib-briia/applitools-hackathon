package ModernTestsV2;

import base.BaseModernTest;
import com.applitools.eyes.RectangleSize;
import org.testng.annotations.Test;
import pages.GalleryPage;

/*
 * Exact copy of ModernTestsV1.Task1
 * No code maintenance done
 * */
public class Task1 extends BaseModernTest {

    @Test(testName = "Cross-Device Elements Test")
    public void testCrossDeviceElements() {
        eyes.open(driver, APPLICATION_NAME, "Task 1", new RectangleSize(800, 600));
        GalleryPage galleryPage = new GalleryPage(driver);
        galleryPage.open();
        eyes.checkWindow("Cross-Device Elements Test");
    }
}
