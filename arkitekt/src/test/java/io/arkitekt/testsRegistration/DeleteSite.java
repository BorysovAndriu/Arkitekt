package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteSite extends TestBase {

    @Test
    public void testDeleteSite() throws Exception {
        app.getNavHelperLeftPanel().initListSite(true);
        int before = app.getNavHelperLeftPanel().getCountSite();
        if (before == 1) {
            app.getNavHelperLeftPanel().initListSite(false);
        } else {
            app.getNavHelperLeftPanel().openFirstSite();
        }
        app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
        app.getSiteEditHelper().deleteSite();
        if (!app.getSiteEditHelper().isElementPressent(By.cssSelector("#choose_template"))) {
            app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
        } else {
            app.getNavHelperLeftPanel().initListSite(true);
            int after = app.getNavHelperLeftPanel().getCountSite();
            Assert.assertEquals(after, before - 1);
        }
    }
}
