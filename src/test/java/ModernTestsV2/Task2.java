package ModernTestsV2;

import base.BaseModernTest;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;
import pages.GalleryPage;

/*
 * Exact copy of ModernTestsV1.Task2
 * No code maintenance done
 * */
public class Task2 extends BaseModernTest {

    @Test(testName = "Filter Results")
    public void testFilterResults() {
        eyes.open(driver, APPLICATION_NAME, "Task 2", new RectangleSize(VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
        GalleryPage galleryPage = new GalleryPage(driver);
        galleryPage.open();
        galleryPage.filter("colors", "Black");
        eyes.check(Target.region(galleryPage.product_grid).withName("Filter Results"));
    }
}
