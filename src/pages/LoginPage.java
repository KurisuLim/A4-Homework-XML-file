package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    //elements
    @FindBy(css = "h5")
    public WebElement cardTitle;
    @FindBy(id ="email")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(css = "button")
    public WebElement signInButton;
    @FindBy(css = ".has-error .help-block")
    public WebElement requireError;
    @FindBy(className = "alert")
    public WebElement alert;
    @FindBy(className = "title")
    public WebElement pageTitle;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return cardTitle.getText().contains("email address and password");
    }

    public void setEmail(String text){
        email.clear();
        email.sendKeys(text);
    }

    public void setPassword(String text){
        password.clear();
        password.sendKeys(text);
    }

    public void setupLogin(String email, String password){
        setEmail(email);
        setPassword(password);
        signInButton.click();
    }
}
