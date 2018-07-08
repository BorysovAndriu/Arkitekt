package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class PageBanner extends TestBasePages {

    @Test(priority = 1)
    public void addPage() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_page']"), "NEW PAGE");
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 3)
    public void addBannerText() throws Exception {
        app.getBannerHelper().addBannerText(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 4)
    public void minBannerHeight() throws Exception {
        app.getBannerHelper().moveBannerHeight(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 5)
    public void addBannerButtonContent() throws Exception {
        app.getBannerHelper().insertContentHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"), "/new-page", "New Page - Marathon");
    }

    @Test(priority = 6)
    public void addBannerButtonFile() throws InterruptedException, FileNotFoundException {
        app.getBannerHelper().insertFileHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 7)
    public void addBannerButtonExternal() throws InterruptedException {
        app.getBannerHelper().insertExtrenalHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"), "Google");
    }

    @Test(priority = 8)
    public void addBannerOffButton() throws InterruptedException {
        app.getBannerHelper().insertNoneHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 9)
    public void deleteBannerText() throws Exception {
        app.getBannerHelper().deleteBannerText(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 10)
    public void deleteBanner() throws Exception {
        app.getBannerHelper().deleteImage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
    }

    @Test(priority = 11)
    public void deletePage() throws Exception {
        app.getPagesHelper().deletePage(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]"),
                By.xpath("//*[@id='menu_item_remove']"));
    }

}
