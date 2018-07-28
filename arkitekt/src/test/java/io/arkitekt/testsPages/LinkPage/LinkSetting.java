package io.arkitekt.testsPages.LinkPage;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LinkSetting extends TestBasePages {

    @Test(priority = 1)
    public void addLink() throws Exception {
        app.getPagesHelper().addPages( "NEW LINK", 4);
    }

    @Test(priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggle("HOME", 4);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggle("NEW LINK", 4);
    }

    @Test(priority = 4)
    public void renamePage() throws InterruptedException {
        app.getPagesHelper().renamePage( "LINK", 4);
    }

    @Test(priority = 5)
    public void deleteLink() throws Exception {
        app.getPagesHelper().deletePages(4, "HOME");
    }
}
