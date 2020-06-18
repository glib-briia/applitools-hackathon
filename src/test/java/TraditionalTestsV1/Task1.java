package TraditionalTestsV1;

import base.BaseTraditionalTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GalleryPage;
import pages.GalleryPage.Filter;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utilities.TraditionalReporter.hackathonReporter;

/*
 * Ensure elements are properly hidden or displayed in different viewports and on different browsers.
 * */
public class Task1 extends BaseTraditionalTest {

    private static final int TASK_ID = 1;
    private GalleryPage galleryPage;

    @BeforeClass(alwaysRun = true)
    public void beforeAll() {
        galleryPage = new GalleryPage(driver);
        galleryPage.open();
    }

    @Test(testName = "Site logo should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 1)
    public void testSiteLogoShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Site logo is displayed", context,
                galleryPage.header.siteLogo, galleryPage.header.siteLogo.isDisplayed())).isTrue();
    }

    @Test(testName = "Header navigation menu should be displayed", groups = {Laptop}, priority = 2)
    public void testNavigationMenuShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Header navigation menu is displayed", context, galleryPage.header.navigationMenu,
                galleryPage.header.navigationMenu.isDisplayed())).isTrue();
    }

    @Test(testName = "Header navigation menu should be hidden", groups = {Tablet, iPhone_X}, priority = 2)
    public void testNavigationMenuShouldBeHidden(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Header navigation is hidden", context, galleryPage.header.navigationMenu,
                !galleryPage.header.navigationMenu.isDisplayed())).isTrue();
    }

    @Test(testName = "Search field should be displayed with placeholder text 'Search over 10,000 shoes!'", groups = {Laptop, Tablet}, priority = 3)
    public void testSearchFieldDisplayedWithCorrectPlaceholderText(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Search field is displayed", context, galleryPage.header.searchField,
                galleryPage.header.searchField.isDisplayed())).isTrue();
        assertThat(hackathonReporter(TASK_ID, "Search placeholder text is equal to 'Search over 10,000 shoes!'", context, galleryPage.header.searchField,
                galleryPage.header.searchField.getAttribute("placeholder").equals("Search over 10,000 shoes!"))).isTrue();
    }

    @Test(testName = "Search field should be hidden", groups = {iPhone_X}, priority = 3)
    public void testSearchFieldIsHidden(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Search field is displayed", context, galleryPage.header.searchField,
                !galleryPage.header.searchField.isDisplayed())).isTrue();
    }

    @Test(testName = "Search icon should be displayed", groups = {Laptop, Tablet}, priority = 4)
    public void testSearchIconShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Search icon is displayed", context, galleryPage.header.searchIcon,
                galleryPage.header.searchIcon.isDisplayed())).isTrue();
    }

    @Test(testName = "Search icon should be displayed", groups = {iPhone_X}, priority = 4)
    public void testSearchIconShouldBeDisplayedMobile(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Search icon is displayed", context, galleryPage.header.searchIconMobile,
                galleryPage.header.searchIconMobile.isDisplayed())).isTrue();
    }

    @Test(testName = "Account access link should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 5)
    public void testAccountAccessLinkShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Account link is displayed", context, galleryPage.header.accountLink,
                galleryPage.header.accountLink.isDisplayed())).isTrue();
    }

    @Test(testName = "Wish list link should be displayed", groups = {Laptop}, priority = 6)
    public void testWishListLinkShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Wish list link is displayed", context, galleryPage.header.wishlistLink,
                galleryPage.header.wishlistLink.isDisplayed())).isTrue();
    }

    @Test(testName = "Wish list link should be hidden", groups = {Tablet, iPhone_X}, priority = 6)
    public void testWishListLinkShouldBeHidden(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Wish list link is hidden", context, galleryPage.header.wishlistLink,
                !galleryPage.header.wishlistLink.isDisplayed())).isTrue();
    }

    @Test(testName = "Shopping cart link should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 7)
    public void testShoppingCartShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Shopping cart link is displayed", context, galleryPage.header.shoppingCartLink,
                galleryPage.header.shoppingCartLink.isDisplayed())).isTrue();
    }

    @Test(testName = "Shopping cart counter should be displayed with 2 products", groups = {Laptop, Tablet}, priority = 8)
    public void testShoppingCartCounterShouldBeDisplayedWith2Products(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Shopping cart counter is displayed", context, galleryPage.header.shoppingCartCount,
                galleryPage.header.shoppingCartCount.isDisplayed())).isTrue();
        assertThat(hackathonReporter(TASK_ID, "Shopping cart counter text is equal to '2'", context, galleryPage.header.shoppingCartCount,
                galleryPage.header.shoppingCartCount.getText().equals("2"))).isTrue();
    }

    @Test(testName = "Shopping cart counter should be hidden", groups = {iPhone_X}, priority = 8)
    public void testShoppingCartCounterShouldBeHidden(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Shopping cart counter is hidden", context, galleryPage.header.shoppingCartCount,
                !galleryPage.header.shoppingCartCount.isDisplayed())).isTrue();
    }

    /* Main section */

    @Test(testName = "Sort type select should be displayed with default option set to 'Sort by popularity'", groups = {Laptop, Tablet, iPhone_X}, priority = 9)
    public void testDefaultSortShouldBeCorrect(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Sort select is displayed", context, galleryPage.sortDropdown,
                galleryPage.sortDropdown.isDisplayed())).isTrue();
        assertThat(hackathonReporter(TASK_ID, "Default sort type is 'Sort by popularity'", context, galleryPage.sortDropdown,
                new Select(galleryPage.sortDropdown).getFirstSelectedOption().getText().trim().equals("Sort by popularity"))).isTrue();
    }

    @Test(testName = "Grid/List view toggles should be displayed", groups = {Laptop}, priority = 10)
    public void testGridViewToggleShouldBeDisplayed(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "List view toggle is displayed", context, galleryPage.listViewToggle,
                galleryPage.listViewToggle.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Grid view toggle is displayed", context, galleryPage.gridViewToggle,
                galleryPage.gridViewToggle.isDisplayed())).isTrue();
        softly.assertAll();
    }

    @Test(testName = "Grid/List view toggles should be hidden", groups = {Tablet, iPhone_X}, priority = 10)
    public void testGridViewToggleShouldBeHidden(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "List view toggle is hidden", context, galleryPage.listViewToggle,
                !galleryPage.listViewToggle.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Grid view toggle is hidden", context, galleryPage.gridViewToggle,
                !galleryPage.gridViewToggle.isDisplayed())).isTrue();
        softly.assertAll();
    }

    @Test(testName = "'Filters' label should be hidden", groups = {Laptop, iPhone_X}, priority = 11)
    public void testFiltersLabelShouldBeHidden(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "'Filters' label is hidden", context, galleryPage.filtersLabel,
                !galleryPage.filtersLabel.isDisplayed())).isTrue();
    }

    @Test(testName = "'Filters' label should be displayed", groups = {Tablet}, priority = 11)
    public void testFiltersLabelShouldBeDisplayed(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "'Filters' label is displayed", context, galleryPage.filtersLabel,
                galleryPage.filtersLabel.isDisplayed())).isTrue();
    }

    @Test(testName = "Filters should be displayed with correct names", groups = {Laptop}, priority = 12)
    public void testFiltersShouldBeDisplayedWithCorrectNames(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Filters are displayed", context, galleryPage.filter_col, galleryPage.filter_col.isDisplayed())).isTrue();

        List<Filter> filters = galleryPage.getFilters();
        String[] expectedFiltersNames = new String[]{"type", "colors", "brands", "price"};
        SoftAssertions softly = new SoftAssertions();
        for (int index = 0; index < expectedFiltersNames.length; index++) {
            softly.assertThat(hackathonReporter(TASK_ID, String.format("%s filter name is not correct", expectedFiltersNames[index]), context, filters.get(index).getName(),
                    filters.get(index).getName().getText().equals(expectedFiltersNames[index]))).isTrue();
        }
        softly.assertAll();
    }

    @Test(testName = "Filters should be hidden", groups = {Tablet, iPhone_X}, priority = 12)
    public void testFiltersShouldBeHidden(ITestContext context) {
        assertThat(hackathonReporter(TASK_ID, "Filters are displayed", context, galleryPage.filter_col, !galleryPage.filter_col.isDisplayed())).isTrue();
    }

    /* Footer */

    @Test(testName = "Footer sections headers should be displayed", groups = {Laptop, Tablet, iPhone_X}, priority = 13)
    public void testFooterQuickLinksShouldBeCorrect(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "'Quick links' footer category is displayed", context, galleryPage.footer.quickLinksCategory,
                galleryPage.footer.quickLinksCategory.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "'Contacts' footer category is displayed", context, galleryPage.footer.contactsCategory,
                galleryPage.footer.contactsCategory.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "'Keep in touch' footer category is displayed", context, galleryPage.footer.keepInTouchCategory,
                galleryPage.footer.keepInTouchCategory.isDisplayed())).isTrue();
        softly.assertAll();
    }

    @Test(testName = "Footer sections should be displayed", groups = {Laptop, Tablet}, priority = 14)
    public void testFooterSectionsAreDisplayed(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "Quick links section is displayed", context, galleryPage.footer.linksSection,
                galleryPage.footer.linksSection.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Contacts section is displayed", context, galleryPage.footer.contactsSection,
                galleryPage.footer.contactsSection.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Newsletter section is displayed", context, galleryPage.footer.newsletterSection,
                galleryPage.footer.newsletterSection.isDisplayed())).isTrue();
        softly.assertAll();
    }

    @Test(testName = "Footer sections should be hidden", groups = {iPhone_X}, priority = 14)
    public void testFooterSectionsAreHidden(ITestContext context) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hackathonReporter(TASK_ID, "Quick links section is hidden", context, galleryPage.footer.linksSection,
                !galleryPage.footer.linksSection.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Contacts section is hidden", context, galleryPage.footer.contactsSection,
                !galleryPage.footer.contactsSection.isDisplayed())).isTrue();
        softly.assertThat(hackathonReporter(TASK_ID, "Newsletter section is hidden", context, galleryPage.footer.newsletterSection,
                !galleryPage.footer.newsletterSection.isDisplayed())).isTrue();
        softly.assertAll();
    }
}
