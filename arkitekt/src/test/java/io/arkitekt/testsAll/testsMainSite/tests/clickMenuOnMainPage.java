package io.arkitekt.testsAll.testsMainSite.tests;

import io.arkitekt.testsAll.testsMainSite.TestBaseMainSite;
import org.testng.annotations.Test;

import java.io.IOException;

public class clickMenuOnMainPage  extends TestBaseMainSite {

    @Test
    public void clickMenu() throws InterruptedException, IOException {
        mainSite.getMainSiteHelper().clickMenuOnMainPage();
    }
}
