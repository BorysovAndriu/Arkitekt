package io.arkitekt.testsRegistration;

import org.testng.annotations.Test;

public class ClickNavigation extends TestBase {

    @Test
    public void navBuiler() throws InterruptedException {
        app.getNavHelperBuilder().movetoNavBuilder();
        app.getNavHelperBuilder().movetoNavpreview();
    }
}
