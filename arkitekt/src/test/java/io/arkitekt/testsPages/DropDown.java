package io.arkitekt.testsPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DropDown extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_folder']"), "NEW DROPDOWN");
        app.getPagesHelper().addSubPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]//a"));
    }

    @Test(priority = 2)
    public void renameDropDown() throws InterruptedException {
        app.getPagesHelper().renamePage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "Drop",
                By.xpath("//input[@name='nav_title']"), "DROP");
    }

    @Test(priority = 4)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deleteDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
    }
}
