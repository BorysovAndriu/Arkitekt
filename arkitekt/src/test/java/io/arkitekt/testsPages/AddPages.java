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
        app.getPagesHelper().deletePages(By.xpath("//div[@id=\"site_pages\"]/div[1]"),
                By.xpath("//*[@id='menu_item_remove']"));
        app.getPagesHelper().checkingNavPages("HOME", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 3)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_container']"));
        app.getPagesHelper().checkingNavPages("NEW CONTAINER", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        app.getPagesHelper().addSubPagesC();
    }

    @Test(priority = 4)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deletePages(By.xpath("//div[@id=\"site_pages\"]/div[1]"),
                By.xpath("//*[@id=\"menu_item_remove\"]"));
        app.getNavHelperLeftPanel().checkingText("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 5)
    public void addDropDown() throws Exception {

        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_folder']"));
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().checkingText("NEW DROPDOWN", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span[1]"));
        app.getNavHelperLeftPanel().stopFrame();
        app.getPagesHelper().addSubPagesD();
    }

    @Test(priority = 6)
    public void deleteDropDown() throws Exception {
        app.getNavHelperLeftPanel().click(By.xpath("//li//a[@href='#!/pages']"));
        app.getNavHelperLeftPanel().hover(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[3]/button"));
        //app.getNavHelperLeftPanel().click(By.xpath("//*[@id=\"menu_item_remove\"]"));
        app.getNavHelperLeftPanel().refresh();
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().checkingText("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 7)
    public void addLink() throws Exception {

        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_link']"));
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().refresh();
        app.getNavHelperLeftPanel().checkingText("New Link", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test(priority = 8)
    public void deleteLink() throws Exception {

        app.getNavHelperLeftPanel().click(By.xpath("//li//a[@href='#!/pages']"));
        app.getNavHelperLeftPanel().hover(By.xpath("//div[@id=\"site_pages\"]/div[1]"),
                By.xpath("//div[@id=\"site_pages\"]/div[1]/div/div[3]/button"));
        //app.getNavHelperLeftPanel().click(By.xpath("//*[@id=\"menu_item_remove\"]"));
        app.getNavHelperLeftPanel().refresh();
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().checkingText("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }




}
