package org.swaglabs.tests;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductPage;
import org.testng.Assert;
import org.swaglabs.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;



    @Test(priority = 1)
    public void verifyLoginPageLoadsSuccessfully(){

        loginPage = new LoginPage(page);
        page.navigate("https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.isLogoVisible());
    }



    @Test(priority = 2)
    public void loginWithValidCredentialsShouldNavigateToProductList() {

        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        page.navigate("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productPage.isInventoryListVisible());
    }





}
