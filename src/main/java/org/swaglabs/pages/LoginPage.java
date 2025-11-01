package org.swaglabs.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final  Page page;


    private String userNameField = "//input[@id='user-name']";
    private String passwordField = "//input[@id='password']";
    private String loginButton = "//input[@id='login-button']";
    private String loginLogo = "//div[@class='login_logo']";

  public LoginPage(Page page){
        this.page = page;
    }



    public void enterUserName(String username) {

      page.locator(this.userNameField).fill(username);

    }


    public void enterPassword(String password) {

        page.locator(this.passwordField).fill(password);

    }


    public void clickLogin() {

        page.locator(this.loginButton).click();

    }


    public void login(String username, String password){
      page.locator(this.userNameField).fill(username);
      page.locator(this.passwordField).fill(password);
      page.locator(this.loginButton).click();
    }

    public boolean isLogoVisible(){
       return  page.locator(this.loginLogo).isVisible();

    }

}
