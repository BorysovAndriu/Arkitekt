package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ContainerBanner extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_container']"), "NEW CONTAINER");
        app.getPagesHelper().addSubContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 3)
    public void addBannerText() throws Exception {
        app.getBannerHelper().addBannerText(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 4)
    public void minBannerHeight() throws Exception {
        app.getBannerHelper().moveBannerHeight(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 5)
    public void addBannerButtonContent() throws Exception {
        app.getBannerHelper().insertContentHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "/new-container", "New Container - Marathon");
    }

    @Test(priority = 6)
    public void addBannerButtonFile() throws InterruptedException, FileNotFoundException {
        app.getBannerHelper().insertFileHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 7)
    public void addBannerButtonExternal() throws InterruptedException {
        app.getBannerHelper().insertExtrenalHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"), "Google");
    }

    @Test(priority = 8)
    public void addBannerOffButton() throws InterruptedException {
        app.getBannerHelper().insertNoneHyperlink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 9)
    public void deleteBannerText() throws Exception {
        app.getBannerHelper().deleteBannerText(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 10)
    public void deleteBanner() throws Exception {
        app.getBannerHelper().deleteImage(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]"));
    }

    @Test(priority = 11)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deleteContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
    }
}

