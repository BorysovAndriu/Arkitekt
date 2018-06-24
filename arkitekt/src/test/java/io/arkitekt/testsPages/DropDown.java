package io.arkitekt.testsPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DropDown extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_folder']"), "NEW DROPDOWN");
        app.getPagesHelper().addSubDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]//a"), "NEW PAGE");
    }

    @Test(priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggleOff(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME");
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggleOn(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW DROPDOWN");
    }

    @Test(priority = 3)
    public void renameDropDown() throws InterruptedException {
        app.getPagesHelper().renamePage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "Drop",
                By.xpath("//input[@name='nav_title']"), "DROP");
    }

    @Test(priority = 4)
    public void renameSubDropDown() throws InterruptedException {
        app.getPagesHelper().renameSubPage
                (By.xpath("//div[@class='site-menu-item menu-item-page d-menu-sub-item active']/div[1]"),
                        By.xpath("//input[@name='nav_title']"), "SUBPAGE");
    }

    @Test(priority = 5)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deleteDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//button[@id=\"menu_item_remove\"]"));
    }
}
