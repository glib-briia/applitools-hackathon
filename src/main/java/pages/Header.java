package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 *  Header Page object fragment
 *  Extracted to a separate class for reusability
 * */
public class Header extends BasePage {

    @FindBy(id = "IMG____9")
    public WebElement siteLogo;

    @FindBy(id = "INPUTtext____42")
    public WebElement searchField;

    @FindBy(id = "I__headericon__44")
    public WebElement searchIcon;

    @FindBy(id = "A__btnsearchm__59")
    public WebElement searchIconMobile;

    @FindBy(id = "DIV__mainmenu__15")
    public WebElement navigationMenu;

    /* Account section */

    @FindBy(className = "dropdown-access")
    public WebElement accountLink;

    @FindBy(className = "wishlist")
    public WebElement wishlistLink;

    @FindBy(className = "dropdown-cart")
    public WebElement shoppingCartLink;

    @FindBy(id = "STRONG____50")
    public WebElement shoppingCartCount;

    public Header(WebDriver driver) {
        super(driver);
    }
}
