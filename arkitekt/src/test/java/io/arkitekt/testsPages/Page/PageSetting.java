package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PageSetting extends TestBasePages {

    @Test(groups ={"PageSetting"}, priority = 1 )
    public void addPage() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_page']"), "NEW PAGE");
    }

    @Test(groups ={"PageSetting"}, priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggleOff(
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME", 1);
    }

    @Test(groups ={"PageSetting"},priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggleOn(
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 4)
    public void renamePage() throws InterruptedException {
        app.getPagesHelper().renamePage("PageSetting",
                By.xpath("//input[@name='nav_title']"), "PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 5)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl("/page-test",
                By.xpath("//*[@name='url' and @placeholder='newpage']"), 1);
    }

    @Test(groups ={"PageSetting"},priority = 6)
    public void lockscreenPage() throws InterruptedException {
        app.getPagesHelper().lockPages(1);
    }

    @Test(groups ={"PageSetting"},priority = 7)
    public void unlockPage() throws InterruptedException {
        app.getPagesHelper().unlockPages("PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 8)
    public void deletePage() throws Exception {
        app.getPagesHelper().deletePage(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]"),
                By.xpath("//*[@id='menu_item_remove']"));
    }
}
