package io.arkitekt.testsPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Page extends TestBasePages {

    @Test(priority = 1)
    public void addPage() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_page']"), "NEW PAGE");
    }

    @Test
    public void toggle() throws InterruptedException {
        app.getPagesHelper().toggle(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW PAGE");
        app.getPagesHelper().toggle(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW PAGE");
    }

    @Test(priority = 2)
    public void renamePage() throws InterruptedException {
        app.getPagesHelper().renamePage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"), "Page",
                By.xpath("//input[@name='nav_title']"), "PAGE");
    }

    @Test(priority = 3)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"), "/page-test",
                By.xpath("//*[@name='url' and @placeholder='newpage']"));
    }

    @Test(priority = 4)
    public void deletePage() throws Exception {
        app.getPagesHelper().deletePage(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]"),
                By.xpath("//*[@id='menu_item_remove']"));
    }
}
