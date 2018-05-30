package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavBuilder extends TestBase {

    @Test
    public void navBuiler() throws InterruptedException {
        app.getNavHelperBuilder().movetoNavBuilder();
        app.getNavHelperBuilder().movetoNavpreview();
    }
}

