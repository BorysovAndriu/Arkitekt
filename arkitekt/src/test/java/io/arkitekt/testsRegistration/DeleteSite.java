package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteSite extends TestBase {

    @Test
    public void testDeleteSite() throws Exception {
        app.getNavHelperLeftPanel().initListSite(true);
        int before = app.getNavHelperLeftPanel().getCountSite();
        app.getNavHelperLeftPanel().initListSite(false);
        app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
        app.getSiteEditHelper().deleteSite();
        app.getNavHelperLeftPanel().gotoMarathon();
        app.getNavHelperLeftPanel().initListSite(true);
        int after = app.getNavHelperLeftPanel().getCountSite();
        Assert.assertEquals(after, before-1);
    }
}
