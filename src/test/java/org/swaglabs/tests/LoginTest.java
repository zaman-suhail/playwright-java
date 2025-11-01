package org.swaglabs.tests;

import com.microsoft.playwright.*;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    LoginPage loginPage;
    ProductPage productPage;


    @BeforeClass
    public void setup(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @Test
    public void verifyLoginPageLoadsSuccessfully(){

        loginPage = new LoginPage(page);
        page.navigate("https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.isLogoVisible());
    }



    @Test
    public void loginWithValidCredentialsShouldNavigateToProductList() {

        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        page.navigate("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productPage.isInventoryListVisible());
    }




    @AfterClass
    public void teardown(){
        browser.close();
        page.close();
    }

}
