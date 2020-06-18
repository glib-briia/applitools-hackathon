package TraditionalTestsV2;

import base.BaseTraditionalTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GalleryPage;
import pages.ProductDetailsPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utilities.TraditionalReporter.hackathonReporter;

/*
 * Copy of TraditionalTestsV1.Task3 plus additional steps to catch missed out defects (step 9)
 * Cannot verify elements layout, overlapping using standard Selenium functionality.
 * Although SKU is displayed it's color is white or shoe_image isn't displayed on Firefox as it's applied as background to div -
 * both cases are not a common selenium tests that you would normally implement
 * and can only be spotted either during manual investigation or using automated visual regression tools
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

    /* Additional tests for added after running on V2*/

    @Test(testName = "Size select should be displayed with default size 'Small (S)'", groups = {Laptop, Tablet, iPhone_X}, priority = 9)
    public void testSizeSelectShouldBeDisplayedWithCorrectSize(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "Size select is displayed", context,
                productDetailsPage.sizeSelect, productDetailsPage.sizeSelect.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Default selected size is 'Small (S)'", context,
                productDetailsPage.sizeSelect, productDetailsPage.getSelectedSize().equals("Small (S)"))).isTrue();
        softly.assertAll();
    }

    @Test(testName = "New product price is displayed and is correct", groups = {Laptop, Tablet, iPhone_X}, priority = 9)
    public void testNewProductPriceIsDisplayedInCorrectFormat(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "New product price is displayed", context,
                productDetailsPage.new_price, productDetailsPage.new_price.isDisplayed())).isTrue();
        //Checking format here as price value itself could be dynamic
        softly.assertThat(hackathonReporter(TASK_ID, "New product price format is correct", context,
                productDetailsPage.new_price, productDetailsPage.new_price.getText().matches("\\$\\d{1,3}\\.\\d{2}"))).isTrue();
        softly.assertAll();
    }


}
