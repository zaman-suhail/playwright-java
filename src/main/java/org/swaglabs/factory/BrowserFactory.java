package org.swaglabs.factory;

import com.microsoft.playwright.*;
import org.swaglabs.utils.ConfigReader;

import java.util.Properties;

public class BrowserFactory {

  private  static    Playwright playwright;
  private  static    Browser browser;
  private static    BrowserContext browserContext;
  private static    Page page;
  private static ConfigReader config;
  private static Properties prop;



  public static Page init_browser(){

      config = new ConfigReader();

      prop = config.init_prop();


      String browserName = prop.getProperty("browser");
      boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));

      playwright = Playwright.create();

      BrowserType browserType;

      switch (browserName.toLowerCase()){
          case "firefox" : browserType = playwright.firefox();
          break;

          case "safari" : browserType = playwright.webkit();
          break;

          default: browserType = playwright.chromium();

      }


      browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));

      browserContext = browser.newContext();

      page = browserContext.newPage();


      return page;

  }


  public  static void closebrowser(){
      page.close();
      browserContext.close();
      browser.close();
      playwright.close();
  }



}
