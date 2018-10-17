package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class SubPageContainerSetting extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        pages.getPagesHelper().addPages("NEW CONTAINER",2);
        pages.getPagesHelper().addSubPage(22);
    }

    @Test (priority = 2)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle( "", 22);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("", 22);
    }

    @Test(priority = 4)
    public void renameContainer() throws InterruptedException {
        pages.getPagesHelper().renamePage( "SUBCONT", 22);
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        pages.getPagesHelper().renameUrl("/subcont-test", 22);
    }

    @Test(priority = 6)
    public void lockscreenContainer() throws InterruptedException {
        pages.getPagesHelper().lockPages(22, "NEW CONTAINER");
    }

    @Test(priority = 7)
    public void unlockContainer() throws InterruptedException {
        pages.getPagesHelper().unlockPages("CONT", 22);
    }

    @Test(priority = 8)
    public void deleteSubContainer() throws Exception {
        pages.getPagesHelper().deletePages(22, "NEW CONTAINER");
    }

    @Test(priority = 8)
    public void deleteContainer() throws Exception {
        pages.getPagesHelper().deletePages(2, "HOME");
    }
}
