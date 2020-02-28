package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    BasePage page = new BasePage(driver);
    private static String BASE_URL = "https://testkwidos.tk";

    //locators
    @FindBy(css = "ul.user.nav li")
    WebElement signInButton;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage(){
        driver.get(BASE_URL);
        return this;
    }

    public void goToSignPage(){
        signInButton.click();
    }
}
