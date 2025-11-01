package org.swaglabs.pages;

import com.microsoft.playwright.Page;
import org.swaglabs.base.BasePage;

public class LoginPage extends BasePage {



    private String userNameField = "//input[@id='user-name']";
    private String passwordField = "//input[@id='password']";
    private String loginButton = "//input[@id='login-button']";
    private String loginLogo = "//div[@class='login_logo']";

  public LoginPage(Page page){
        super(page);
    }



    public void enterUserName(String username) {

      type(userNameField, username);

    }


    public void enterPassword(String password) {

       type(passwordField, password);

    }


    public void clickLogin() {

       click(loginButton);

    }


    public void login(String username, String password){
      type(userNameField, username);
      type(passwordField,password);
      click(loginButton);
    }

    public boolean isLogoVisible(){
      return isVisible(loginLogo);

    }

}
