package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContainerSetting extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages("NEW CONTAINER",2);
    }

    @Test (priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggle( "HOME", 2);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggle("NEW CONTAINER", 2);
    }

    @Test(priority = 4)
    public void renameContainer() throws InterruptedException {
        app.getPagesHelper().renamePage( "CONT", 2);
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl("/cont-test", 2);
    }

    @Test(priority = 6)
    public void lockscreenContainer() throws InterruptedException {
        app.getPagesHelper().lockPages(2);
    }

    @Test(priority = 7)
    public void unlockContainer() throws InterruptedException {
        app.getPagesHelper().unlockPages("CONT", 2);
    }

    @Test(priority = 8)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deletePages(2, "HOME");
    }
}