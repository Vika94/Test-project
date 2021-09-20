package PageFactory;

import PageFactory.ValueObject.LoginValueObject;
import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;


public class LoginPageFactory extends BasePage {
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement errorText;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        initElements(driver,this);
    }


    public LoginPageFactory openPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPageFactory enterUsername(LoginValueObject loginValueObject) {
        this.userName.sendKeys(loginValueObject.getUserName());
        return this;
    }

    public LoginPageFactory enterPassword(LoginValueObject loginValueObject) {
        this.password.sendKeys(loginValueObject.getPassword());
        return this;
    }

    public LoginPageFactory clickLogin() {
        this.loginButton.click();
        return this;
    }

    public LoginPageFactory checkingErrorText(LoginValueObject loginValueObject) {
        Assert.assertEquals(this.errorText.getText(), loginValueObject.getErrorText());
        return this;
    }


}

