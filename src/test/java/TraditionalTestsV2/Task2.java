package TraditionalTestsV2;

import base.BaseTraditionalTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GalleryPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utilities.TraditionalReporter.hackathonReporter;

/*
 * Copy of TraditionalTestsV1. No additional steps were added
 * Only able to verify number of shoes returned in traditional approach.
 * Unable to verify if exactly black shoes returned using standard selenium functionality.
 *
 * */
public class Task2 extends BaseTraditionalTest {

    private static final int TASK_ID = 2;
    private GalleryPage galleryPage;

    @BeforeClass(alwaysRun = true)
    public void beforeAll() {
        galleryPage = new GalleryPage(driver);
        galleryPage.open();
    }

    @Test(testName = "Filtering by 'Black' color should return 2 black shoes", groups = {Laptop, Tablet, iPhone_X}, priority = 1)
    public void testFilteringByBlackColor(ITestContext context) {
        galleryPage.filter("colors", "Black");
        assertThat(hackathonReporter(TASK_ID, "Filtering by 'Black' color returns 2 black shoes", context,
                galleryPage.product_grid, galleryPage.getProducts().size() == 2)).isTrue();
    }

    /* Cannot verify weather the shoes returned are black or not using standard selenium functionality*/


}
