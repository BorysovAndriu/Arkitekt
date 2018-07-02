package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContainerSetting extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_container']"), "NEW CONTAINER");
        app.getPagesHelper().addSubContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
    }

    @Test (priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggleOff(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME");
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggleOn(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW CONTAINER");
    }

    @Test(priority = 4)
    public void renameContainer() throws InterruptedException {
        app.getPagesHelper().renamePage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "Cont",
                By.xpath("//input[@name='nav_title']"), "CONT");
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "/cont-test",
                By.xpath("//*[@name='url' and @placeholder='newpage']"));
    }

    @Test(priority = 6)
    public void lockscreenContainer() throws InterruptedException {
        app.getPagesHelper().lockPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 7)
    public void unlockContainer() throws InterruptedException {
        app.getPagesHelper().unlockPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"),
                "CONT");
    }

    @Test(priority = 8)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deleteContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
    }
}
