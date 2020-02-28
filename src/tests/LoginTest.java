package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @BeforeMethod
    public void beforeTest(){
        HomePage home = new HomePage(driver);
        home.openHomePage()
            .goToSignPage();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void pageElement(){
        LoginPage page = new LoginPage(driver);
        Assert.assertTrue(page.isPageOpened());
    }

    @Test(groups = {"Regression"})
    public void emptyLogin(){
        LoginPage page = new LoginPage(driver);
        page.setupLogin("", "");
        Assert.assertTrue(page.requireError.isDisplayed());
    }

    @Test(groups = {"Regression"})
    public void invalidLogin(){
        LoginPage page = new LoginPage(driver);
        page.setupLogin("chris.lim@testpro.io", "Lim!1987testpro");
        Assert.assertTrue(page.alert.isDisplayed());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void successLogin(){
        LoginPage page = new LoginPage(driver);
        page.setupLogin("toffer.lim87+testpro@gmail.com", "TestProRocks2020!");
        Assert.assertTrue(page.pageTitle.isDisplayed());
    }
}
