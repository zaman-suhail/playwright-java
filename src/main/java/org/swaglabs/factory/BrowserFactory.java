package org.swaglabs.factory;

import com.microsoft.playwright.*;
import org.swaglabs.utils.ConfigReader;

import java.util.Properties;

public class BrowserFactory {

  private  static    ThreadLocal<Playwright>  playwrightThread = new ThreadLocal<>();
  private  static    ThreadLocal<Browser> browserThread = new ThreadLocal<>();
  private static    ThreadLocal<BrowserContext> browserContextThread = new ThreadLocal<>();
  private static    ThreadLocal<Page> pageThread = new ThreadLocal<>();

  private static ConfigReader config;
  private static Properties prop;



  public static Page init_browser(){

      config = new ConfigReader();

      prop = config.init_prop();


      String browserName = prop.getProperty("browser");
      boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));

      playwrightThread.set(Playwright.create());

      BrowserType browserType;

      switch (browserName.toLowerCase()){
          case "firefox" : browserType = playwrightThread.get().firefox();
          break;

          case "safari" : browserType = playwrightThread.get().webkit();
          break;

          default: browserType = playwrightThread.get().chromium();

      }

      browserThread.set(browserType.launch(new BrowserType.LaunchOptions().setHeadless(isHeadless)));
      browserContextThread.set(browserThread.get().newContext());
      pageThread.set(browserContextThread.get().newPage());


      return pageThread.get();

  }


  public static Page getPage(){
      return pageThread.get();
  }

  public static Playwright getPlaywright(){
      return playwrightThread.get();
  }

  public  static void closebrowser(){
      if(pageThread !=null) pageThread.get().close();
      if(browserContextThread !=null) browserContextThread.get().close();
      if(browserThread != null) browserThread.get().close();
      if(playwrightThread !=null) playwrightThread.get().close();

      pageThread.remove();
      browserContextThread.remove();
      browserThread.remove();
      playwrightThread.remove();
  }



}
