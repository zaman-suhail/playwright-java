package org.swaglabs.base;

import com.microsoft.playwright.*;

import org.swaglabs.factory.BrowserFactory;
import org.swaglabs.utils.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public class BaseTest {

    protected   Playwright playwright;
    protected Browser browser;
    protected   BrowserContext browserContext;
    protected Page page;
    protected ConfigReader config;
    protected Properties prop;


    @BeforeClass
    public void setup(){

        config = new ConfigReader();
        prop = config.init_prop();

        page = BrowserFactory.init_browser();

        String url =  prop.getProperty("url");
      page.navigate(url);


    }


    @AfterClass
    public void teardown(){
        BrowserFactory.closebrowser();

    }

}
