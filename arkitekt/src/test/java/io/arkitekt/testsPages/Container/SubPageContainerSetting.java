package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class SubPageContainerSetting extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages("NEW CONTAINER",2);
        app.getPagesHelper().addSubPage(22);
    }

    @Test (priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggle( "", 22);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggle("", 22);
    }

    @Test(priority = 4)
    public void renameContainer() throws InterruptedException {
        app.getPagesHelper().renamePage( "SUBCONT", 22);
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl("/subcont-test", 22);
    }

    @Test(priority = 6)
    public void lockscreenContainer() throws InterruptedException {
        app.getPagesHelper().lockPages(22);
    }

    @Test(priority = 7)
    public void unlockContainer() throws InterruptedException {
        app.getPagesHelper().unlockPages("CONT", 22);
    }

    @Test(priority = 8)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deletePages(22, "NEW CONTAINER");
        app.getPagesHelper().deletePages(2, "HOME");
    }

}
