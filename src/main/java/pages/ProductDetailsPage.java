package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    public Header header;
    public Footer footer;

    public WebElement shoe_name;
    public WebElement shoe_img;
    public WebElement new_price;

    @FindBy(id = "SPAN__rating__76")
    public WebElement rating;

    @FindBy(id = "SMALL____84")
    public WebElement sku;

    @FindBy(id = "P____83")
    public WebElement description;

    @FindBy(id = "STRONG____90")
    public WebElement sizeLabel;

    @FindBy(id = "STRONG____100")
    public WebElement quantityLabel;

    @FindBy(id = "A__btn__114")
    public WebElement addToCartBtn;

    @FindBy(className = "nice-select")
    public WebElement sizeSelect;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        footer = new Footer(driver);
    }

    public String getSelectedSize() {
        return sizeSelect.findElement(By.className("current")).getText();
    }
}
