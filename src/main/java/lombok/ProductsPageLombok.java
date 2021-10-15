package lombok;

import pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ProductsPageLombok extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCart;

    @FindBy(className = "shopping_cart_link")
    WebElement basket;

    @FindBys({@FindBy(className = "inventory_item_name")})
    private List<WebElement> productNames;

    @FindBys({@FindBy(className = "inventory_item_price")})
    private List<WebElement> prices;

    @FindBys({@FindBy(className = "inventory_item_desc")})
    private List<WebElement> descriptions;

    @FindBy(xpath = "//*[@alt='Sauce Labs Backpack']")
    WebElement image;

    @FindBy(className = "app_logo")
    WebElement logo;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement remove;

    public ProductsPageLombok(WebDriver driver) {
        initElements(driver, this);
    }

    public ProductsPageLombok displayThePrice() {
        prices.forEach((data) -> {
            Assert.assertTrue(data.isDisplayed());
        });
        return this;
    }

    public ProductsPageLombok displayDescriptions() {
        descriptions.forEach((data) -> {
            Assert.assertTrue(data.isDisplayed());
        });
        return this;
    }

    public ProductsPageLombok displayProductNames() {
        productNames.forEach((data) -> {
            Assert.assertTrue(data.isDisplayed());
        });
        return this;
    }

    public ProductsPageLombok clickAddToCart() {
        addToCart.click();
        return this;
    }

    public ProductsPageLombok clickRemove() {
        remove.click();
        return this;
    }

    public ProductsPageLombok clickBasket() {
        basket.click();
        return this;
    }

    public ProductsPageLombok displayImage() {
        image.isDisplayed();
        return this;
    }

    public ProductsPageLombok displayLogo() {
        logo.isDisplayed();
        return this;
    }
}
