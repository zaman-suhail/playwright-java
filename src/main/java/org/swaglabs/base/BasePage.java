package org.swaglabs.base;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(Page page){
        this.page = page;
    }

    //common actions
    public void click(String selector){
        page.locator(selector).click();
    }


    public void type(String selector, String text){
        page.locator(selector).fill(text);
    }

    public boolean isVisible(String selector){
        return page.locator(selector).isVisible();
    }
}
