package io.arkitekt.testsAll.testsMainSite.tests;

import io.arkitekt.testsAll.testsMainSite.TestBaseMainSite;
import org.testng.annotations.Test;

import java.io.IOException;

public class clickMenuOnThemesPage extends TestBaseMainSite {

    @Test
    public void clickMenuOnThemesPage() throws InterruptedException, IOException {
        app.getMainSiteHelper().clickMenuOnThemesPage();
    }
}
