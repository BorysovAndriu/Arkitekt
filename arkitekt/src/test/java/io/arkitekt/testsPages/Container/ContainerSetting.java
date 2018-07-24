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
        app.getPagesHelper().toggleOff(
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME", 2);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggleOn(
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW CONTAINER", 2);
    }

    @Test(priority = 4)
    public void renameContainer() throws InterruptedException {
        app.getPagesHelper().renamePage("Cont",
                By.xpath("//input[@name='nav_title']"), "CONT", 2);
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl("/cont-test",
                By.xpath("//*[@name='url' and @placeholder='newpage']"), 2);
    }

    @Test(priority = 6)
    public void lockscreenContainer() throws InterruptedException {
        app.getPagesHelper().lockPages(2);
    }

    @Test(priority = 7)
    public void unlockContainer() throws InterruptedException {
        app.getPagesHelper().unlockPages(
                "CONT", 2);
    }

    @Test(priority = 8)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deleteContainer(2,
                By.xpath("//*[@id=\"menu_item_remove\"]"));
    }
}
