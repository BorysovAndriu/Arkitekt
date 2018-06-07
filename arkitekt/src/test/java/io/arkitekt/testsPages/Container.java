package io.arkitekt.testsPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Container extends TestBasePages{

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_container']"), "NEW CONTAINER");
        app.getPagesHelper().addSubPages(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
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

    @Test(priority = 4)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deleteContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
    }
}
