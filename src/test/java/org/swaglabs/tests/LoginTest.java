package org.swaglabs.tests;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductPage;
import org.swaglabs.utils.ConfigReader;
import org.testng.Assert;
import org.swaglabs.base.BaseTest;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;



    @Test(priority = 1)
    public void verifyLoginPageLoadsSuccessfully(){

        loginPage = new LoginPage(page);

        Assert.assertTrue(loginPage.isLogoVisible());
    }



    @Test(priority = 2)
    public void loginWithValidCredentialsShouldNavigateToProductList() {



        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        loginPage.login(username, password);
        Assert.assertTrue(productPage.isInventoryListVisible());
    }





}
