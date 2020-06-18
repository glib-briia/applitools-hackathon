package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class GalleryPage extends BasePage {

    public Header header;
    public Footer footer;

    /* Toolbox controls */
    @FindBy(id = "sort")
    public WebElement sortDropdown;

    @FindBy(className = "ti-view-grid")
    public WebElement gridViewToggle;

    @FindBy(className = "ti-view-list")
    public WebElement listViewToggle;

    @FindBy(css = ".open_filters span")
    public WebElement filtersLabel;

    @FindBy(id = "ti-filter")
    public WebElement filtersIcon;

    public WebElement product_grid;

    public WebElement filterBtn;

    public WebElement filter_col;

    public GalleryPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        footer = new Footer(driver);
    }

    public void open() {
        this.driver.get("https://demo.applitools.com/gridHackathon" + System.getenv("APP_VERSION") + ".html");
    }

    public ProductDetailsPage navigateToProductDetailsPage(int productOrdinal) {
        getProducts().get(productOrdinal - 1).getImage().click();
        return new ProductDetailsPage(driver);
    }

    public List<Product> getProducts() {
        return driver.findElements(By.className("grid_item")).stream().map(Product::new).collect(Collectors.toList());
    }

    public List<Filter> getFilters() {
        return driver.findElements(By.className("filter_type")).stream().map(Filter::new).collect(Collectors.toList());
    }

    public void filter(String filterName, String property) {
        if (filtersIcon.isDisplayed()) {
            filtersIcon.click();
        }
        waitForVisibilityOf(filter_col);
        Filter filter = getFilters().stream().filter(f -> f.getName().getText().equals(filterName)).findFirst().get();
        Filter.Option option = filter.getOptions().stream().filter(o -> o.getName().equals(property)).findFirst().get();
        option.select();
        filterBtn.click();
    }

    /*
     * Product class encapsulating repetitive/dynamic products on the page
     */
    public class Product {
        private WebElement productContainer;

        Product(WebElement productContainer) {
            this.productContainer = productContainer;
        }

        public WebElement getOldPrice() {
            return productContainer.findElement(By.className("old_price"));
        }

        public WebElement getNewPrice() {
            return productContainer.findElement(By.className("new_price"));
        }

        public WebElement getImage() {
            return productContainer.findElement(By.className("img-fluid"));
        }

        public WebElement getTitle() {
            return productContainer.findElement(By.cssSelector(".grid_item  h3"));
        }

        public WebElement getCountdown() {
            return productContainer.findElement(By.className("countdown"));
        }

        public WebElement getOffPercent() {
            return productContainer.findElement(By.cssSelector(".ribbon.off"));
        }

        public WebElement getAddToWishListBtn() {
            return productContainer.findElement(By.className("ti-heart"));
        }

        public WebElement getAddToCompareBtn() {
            return productContainer.findElement(By.className("ti-control-shuffle"));
        }

        public WebElement getAddToCartBtn() {
            return productContainer.findElement(By.className("ti-shopping-cart"));
        }


    }

    /*
     * Filter class encapsulating repetitive products on the page
     */
    public class Filter {
        private WebElement filterContainer;

        Filter(WebElement filterContainer) {
            this.filterContainer = filterContainer;
        }

        public WebElement getName() {
            return filterContainer.findElement(By.tagName("a"));
        }

        public List<Option> getOptions() {
            return filterContainer.findElements(By.tagName("li")).stream().map(Option::new).collect(Collectors.toList());
        }

        public class Option {
            private WebElement optionContainer;

            Option(WebElement optionContainer) {
                this.optionContainer = optionContainer;
            }

            public String getName() {
                return optionContainer.findElement(By.className("container_check")).getText().split("\n")[0];
            }

            public void select() {
                optionContainer.findElement(By.className("container_check")).click();
            }

            public Integer getProductsCount() {
                return Integer.parseInt(optionContainer.findElement(By.tagName("small")).getText());
            }

            public boolean isSelected() {
                return optionContainer.findElement(By.cssSelector("input[type='checkbox']")).isSelected();
            }

        }

    }
}
