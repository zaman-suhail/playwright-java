package org.swaglabs.pages;

import com.microsoft.playwright.Page;

public class ProductPage {

    Page page;

    private String inventoryList = "//div[@class='inventory_list']";


    public ProductPage(Page page){
        this.page = page;
    }


    public boolean isInventoryListVisible(){
        return  page.locator(this.inventoryList).isVisible();
    }
}
