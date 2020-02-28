package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClick(WebElement element){
        waitForVisibility(element);
        driver.findElement(By.cssSelector(String.valueOf(element))).click();
    }

    public void setText(WebElement element, String text){
        waitForVisibility(element);
        WebElement ele = driver.findElement(By.cssSelector(String.valueOf(element)));
                ele.clear();
                ele.sendKeys(text);
    }

    public String getText(WebElement element){
        waitForVisibility(element);
        return driver.findElement(By.cssSelector(String.valueOf(element))).getText();
    }

}
