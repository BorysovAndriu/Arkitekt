package io.arkitekt.Pages;

import io.arkitekt.testsRegistration.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddPages extends TestBase {

    @Test
    public void addPage() throws Exception {
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
        app.getNavHelperLeftPanel().gotoAddPages(By.xpath("//a[@id='add_new_page']"));
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().checkingText("NEW PAGE", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test
    public void deletePage() throws Exception {
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
        app.getNavHelperLeftPanel().click(By.xpath("//li//a[@href='#!/pages']"));
        app.getNavHelperLeftPanel().hover(By.xpath("//div[@id=\"site_pages\"]/div[1]"),
                By.xpath("//div[@id=\"site_pages\"]/div[1]/div/div[3]/button"));
        app.getNavHelperLeftPanel().click(By.xpath("//*[@id=\"menu_item_remove\"]"));
        app.getNavHelperLeftPanel().refresh();
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().checkingText("Home", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
    }

    @Test
    public void addContainer() throws Exception {
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
        app.getNavHelperLeftPanel().gotoAddPages(By.xpath("//a[@id='add_new_container']"));
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperLeftPanel().checkingText("NEW CONTAINER", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));

    }



}
