package io.arkitekt.testsRegistration;

import org.testng.annotations.Test;

public class DeleteSite extends TestBase {

    @Test
    public void testDeleteSite() throws Exception {
        app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
        app.getSiteEditHelper().deleteSite();
        app.getNavHelperLeftPanel().initListSite();
    }
}
