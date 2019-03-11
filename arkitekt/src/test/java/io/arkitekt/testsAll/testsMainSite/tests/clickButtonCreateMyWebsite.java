package io.arkitekt.testsAll.testsMainSite.tests;

import io.arkitekt.testsAll.testsMainSite.TestBaseMainSite;
import org.testng.annotations.Test;

public class clickButtonCreateMyWebsite extends TestBaseMainSite {

    @Test
    public void chooseWebSite() throws InterruptedException {
        app.getMainSiteHelper().createMyWebsite();
    }
}
