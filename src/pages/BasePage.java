package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    final String BASE_URL = "https://testkwidos.tk/auth/login";

    //constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForVisibility(By element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public void waitForClick(By element){
        waitForVisibility(element);
        driver.findElement(element).click();
    }

    public void setText(By element, String text){
        waitForVisibility(element);
        WebElement ele = driver.findElement(element);
                ele.clear();
                ele.sendKeys(text);
    }

    public String getText(By element){
        waitForVisibility(element);
        return driver.findElement(element).getText();
    }

}
