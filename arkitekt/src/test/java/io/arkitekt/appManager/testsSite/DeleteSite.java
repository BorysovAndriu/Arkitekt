package io.arkitekt.appManager.testsSite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteSite extends TestBase {

    @Test
    public void testDeleteSite() throws Exception {
        if (!app.getSiteEditHelper().isElementPresent(By.cssSelector("#choose_template"))) {
            app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));

            app.getNavHelperLeftPanel().initListSite(true);
            int oneSiteMustBe = app.getNavHelperLeftPanel().getCountSite();
            Assert.assertEquals(oneSiteMustBe, 1);
            app.getNavHelperLeftPanel().initListSite(false);
            app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
            app.getSiteEditHelper().deleteSite();
            app.getSiteEditHelper().isElementPresent(By.xpath("//img[@alt='Marathon']"));
        } else {
            app.getNavHelperLeftPanel().initListSite(true);
            int before = app.getNavHelperLeftPanel().getCountSite();
            app.getNavHelperLeftPanel().initListSite(false);
            app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
            app.getSiteEditHelper().deleteSite();
            Thread.sleep(5000);
            if (app.getSiteEditHelper().isElementPresent(By.cssSelector("#choose_template"))) {
                app.getNavHelperLeftPanel().initListSite(true);
                int after = app.getNavHelperLeftPanel().getCountSite();
                Assert.assertEquals(after, before - 1);
            } else {
                app.getNavHelperLeftPanel().isElementPresent(By.xpath("//img[@alt='Marathon']"));
            }
        }
    }
}
