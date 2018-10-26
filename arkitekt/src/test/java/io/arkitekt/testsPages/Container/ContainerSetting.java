package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class ContainerSetting extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        pages.getPagesHelper().addPages("NEW CONTAINER",2);
    }
/*
    @Test (priority = 2)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle( "HOME", 2);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("NEW CONTAINER", 2);
    }
*/
    @Test(priority = 4)
    public void renameContainer() throws InterruptedException {
        pages.getPagesHelper().renamePage( "CONT", 2);
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        pages.getPagesHelper().renameUrl("/cont-test", 2);
    }

    @Test(priority = 6)
    public void lockscreenContainer() throws InterruptedException {
        pages.getPagesHelper().lockPages(2, "CONT");
    }

    @Test(priority = 7)
    public void unlockContainer() throws InterruptedException {
        pages.getPagesHelper().unlockPages("CONT", 2);
    }

    @Test(priority = 8)
    public void deleteContainer() throws Exception {
        pages.getPagesHelper().deletePages(2, "HOME");
    }
}
