package TraditionalTestsV1;

import base.BaseTraditionalTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GalleryPage;
import pages.ProductDetailsPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utilities.TraditionalReporter.hackathonReporter;

/*
 * Click on the first Black shoe to navigate to its details page. Check if everything looks good and accurate.
 * */
public class Task3 extends BaseTraditionalTest {

    private static final int TASK_ID = 3;
    private GalleryPage galleryPage;
    private ProductDetailsPage productDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void beforeAll() {
        galleryPage = new GalleryPage(driver);
        galleryPage.open();
        galleryPage.filter("colors", "Black");
        productDetailsPage = galleryPage.navigateToProductDetailsPage(1);
    }

    @Test(testName = "Product title should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 1)
    public void testProductTitleShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product title is displayed", context,
                productDetailsPage.shoe_name, productDetailsPage.shoe_name.isDisplayed())).isTrue();
    }

    @Test(testName = "Product image should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 2)
    public void testProductImageShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product image is displayed", context,
                productDetailsPage.shoe_img, productDetailsPage.shoe_img.isDisplayed())).isTrue();
    }

    @Test(testName = "Product rating should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 3)
    public void testProductRatingShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product rating is displayed", context,
                productDetailsPage.rating, productDetailsPage.rating.isDisplayed())).isTrue();
    }

    @Test(testName = "Product sku should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 4)
    public void testProductSkuShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product sku is displayed", context,
                productDetailsPage.sku, productDetailsPage.sku.isDisplayed())).isTrue();
    }

    @Test(testName = "Product description should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 5)
    public void testProductDescriptionShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product description is displayed", context,
                productDetailsPage.description, productDetailsPage.description.isDisplayed())).isTrue();
    }

    @Test(testName = "Product size label should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 6)
    public void testProductSizeLabelShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product size label is displayed", context,
                productDetailsPage.sizeLabel, productDetailsPage.sizeLabel.isDisplayed())).isTrue();
    }

    @Test(testName = "Product quantity label should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 7)
    public void testProductQuantityLabelShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Product quantity label is displayed", context,
                productDetailsPage.quantityLabel, productDetailsPage.quantityLabel.isDisplayed())).isTrue();
    }

    @Test(testName = "'Add to cart' button should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 8)
    public void testAddToCartBtnShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Add to cart' button is displayed", context,
                productDetailsPage.addToCartBtn, productDetailsPage.addToCartBtn.isDisplayed())).isTrue();
    }
}
