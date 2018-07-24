package io.arkitekt.testsRegistration;

import org.testng.annotations.Test;


public class PreviewSite extends TestBasePreview {

    @Test
    public void testLivePreview() throws Exception {
        app1.getNavHelperLeftPanel().gotoGetStart();
        app1.getNavHelperLeftPanel().gotoMarathon();
        app1.getNavHelperLeftPanel().gotoTab();
        app1.getNavHelperBuilder().movetoNavOutPreview();
        app1.getNavHelperBuilder().closeTab();
    }
}
