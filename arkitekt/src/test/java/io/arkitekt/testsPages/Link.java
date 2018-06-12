package io.arkitekt.testsPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Link extends TestBasePages {

    @Test(priority = 1)
    public void addLink() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_link']"), "NEW LINK");
    }

    @Test
    public void toggle() throws InterruptedException {
        app.getPagesHelper().toggleOff(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "HOME");
        app.getPagesHelper().toggleOn(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//input[@name='enable-page']/following-sibling::span"), "NEW LINK");
    }

    @Test(priority = 2)
    public void renamePage() throws InterruptedException {
        app.getPagesHelper().renamePage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"), "Link",
                By.xpath("//input[@name='nav_title']"), "LINK");
    }

    @Test(priority = 4)
    public void deleteLink() throws Exception {
        app.getPagesHelper().deleteLink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }
}
