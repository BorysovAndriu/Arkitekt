package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
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
        app.getPagesHelper().toggleOff(
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME", 3);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggleOn(
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW DROPDOWN", 3);
    }

    @Test(priority = 3)
    public void renameDropDown() throws InterruptedException {
        app.getPagesHelper().renamePage("Drop",
                By.xpath("//input[@name='nav_title']"), "DROP", 3);
    }

    @Test(priority = 4)
    public void renameSubDropDown() throws InterruptedException {
        app.getPagesHelper().renameSubPage
                (By.xpath("//input[@name='nav_title']"), "SUBPAGE", 3);
    }

    @Test(priority = 5)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deleteDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//button[@id=\"menu_item_remove\"]"));
    }
}
