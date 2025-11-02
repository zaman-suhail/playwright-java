package org.swaglabs.base;

import com.microsoft.playwright.*;

import org.swaglabs.utils.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected   Playwright playwright;
    protected Browser browser;
    protected   BrowserContext browserContext;
    protected Page page;


    @BeforeClass
    public void setup(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();

        String url = ConfigReader.getProperty("url");
        page.navigate(url);
    }


    @AfterClass
    public void teardown(){
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();

    }

}
