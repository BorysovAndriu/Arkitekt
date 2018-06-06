package io.arkitekt.testsPages;

import io.arkitekt.testsRegistration.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddPages extends TestBase {

    @Test(priority = 1)
    public void addPage() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_page']"));
        app.getPagesHelper().checkingNavPages("NEW PAGE", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 2)
    public void deletePage() throws Exception {
        app.getPagesHelper().deletePage(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]"),
                By.xpath("//*[@id='menu_item_remove']"));
        app.getPagesHelper().checkingNavPages("HOME", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 3)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_container']"));
        app.getPagesHelper().checkingNavPages("NEW CONTAINER", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        app.getPagesHelper().addSubPages();
    }

    @Test(priority = 4)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deleteContainer(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
        app.getPagesHelper().checkingNavPages("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
    }

    @Test(priority = 5)
    public void addDropDown() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_folder']"));
        app.getPagesHelper().checkingNavPages("NEW DROPDOWN", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        app.getPagesHelper().addSubPages();
    }

    @Test(priority = 6)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deleteDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
        app.getPagesHelper().checkingNavPages("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
    }

    @Test(priority = 7)
    public void addLink() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_link']"));
        app.getNavHelperLeftPanel().checkingText("New Link", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 8)
    public void deleteLink() throws Exception {
        app.getPagesHelper().deleteLink(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        app.getNavHelperLeftPanel().checkingText("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }




}
