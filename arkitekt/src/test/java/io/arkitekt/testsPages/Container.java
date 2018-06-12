package io.arkitekt.testsPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Container extends TestBasePages{

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_container']"), "NEW CONTAINER");
        app.getPagesHelper().addSubPages(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
    }

    @Test
    public void toggle() throws InterruptedException {
        app.getPagesHelper().toggleOff(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME");
        app.getPagesHelper().toggleOn(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW CONTAINER");
    }

    @Test(priority = 2)
    public void renameContainer() throws InterruptedException {
        app.getPagesHelper().renamePage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "Cont",
                By.xpath("//input[@name='nav_title']"), "CONT");
    }

    @Test(priority = 3)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "/cont-test",
                By.xpath("//*[@name='url' and @placeholder='newpage']"));
    }

    @Test
    public void lockscreenContainer() throws InterruptedException {
        app.getPagesHelper().lockPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test
    public void unlockContainer() throws InterruptedException {
        app.getPagesHelper().unlockPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                "NEW CONTAINER");
    }

    @Test(priority = 4)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deleteContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
    }
}
