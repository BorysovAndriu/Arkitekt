package io.arkitekt.testsAll.testsMainSite.tests;

import io.arkitekt.testsAll.testsMainSite.TestBaseMainSite;
import org.testng.annotations.Test;


public class clickLivePreviewThemes extends TestBaseMainSite {

    @Test
    public void clickLivePreview() throws InterruptedException {
        app.getMainSiteHelper().openPreviewThemes();
    }

}
