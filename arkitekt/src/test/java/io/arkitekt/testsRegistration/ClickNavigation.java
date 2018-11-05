package io.arkitekt.testsRegistration;

import io.arkitekt.testsSite.TestBase;
import org.testng.annotations.Test;

public class ClickNavigation extends TestBase {

    @Test
    public void navBuiler() throws InterruptedException {
        app.getNavHelperBuilder().movetoNavBuilder();
        app.getNavHelperBuilder().movetoNavpreview();
    }
}
