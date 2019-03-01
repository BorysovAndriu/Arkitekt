package io.arkitekt.testsAll.testsMainSite.tests;

import io.arkitekt.testsAll.testsMainSite.TestBaseMainSite;
import org.testng.annotations.Test;

public class clickButtonGetStarted extends TestBaseMainSite {

    @Test
    public void getStarted() throws InterruptedException {
        mainSite.getMainSiteHelper().getStarted();
    }
}
