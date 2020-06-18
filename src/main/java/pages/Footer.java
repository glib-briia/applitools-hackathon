package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 *  Footer Page object fragment
 *  Extracted to a separate class for reusability
 *
 * */
public class Footer extends BasePage {

    @FindBy(css = "h3[data-target='#collapse_1']")
    public WebElement quickLinksCategory;

    @FindBy(css = "h3[data-target='#collapse_3']")
    public WebElement contactsCategory;

    @FindBy(css = "h3[data-target='#collapse_4']")
    public WebElement keepInTouchCategory;

    @FindBy(id = "collapse_1")
    public WebElement linksSection;

    @FindBy(id = "collapse_3")
    public WebElement contactsSection;

    @FindBy(id = "collapse_4")
    public WebElement newsletterSection;

    public Footer(WebDriver driver) {
        super(driver);
    }
}
