package org.swaglabs.tests;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductPage;
import org.swaglabs.utils.ConfigReader;
import org.testng.Assert;
import org.swaglabs.base.BaseTest;
import org.testng.annotations.Test;

import java.net.URL;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;



    @Test(priority = 1)
    public void verifyLoginPageLoadsSuccessfully(){
        String url = ConfigReader.getProperty("URL");

        loginPage = new LoginPage(page);
        page.navigate(url);
        Assert.assertTrue(loginPage.isLogoVisible());
    }



    @Test(priority = 2)
    public void loginWithValidCredentialsShouldNavigateToProductList() {


        String url = ConfigReader.getProperty("URL");
        String username = ConfigReader.getProperty("USER_NAME");
        String password = ConfigReader.getProperty("PASSWORD");

        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        page.navigate(url);
        loginPage.login(username, password);
        Assert.assertTrue(productPage.isInventoryListVisible());
    }





}
