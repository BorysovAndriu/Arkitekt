package io.arkitekt.testsAll.testsPages.Page;

import io.arkitekt.testsAll.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class PageSetting extends TestBasePages {

    @Test(priority = 1 )
    public void addPage() throws Exception {
        pages.getPagesHelper().addPages( "NEW PAGE", 1);
    }

    @Test(priority = 2)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle("HOME", 1);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("NEW PAGE", 1);
    }

    @Test(priority = 4)
    public void renamePage() throws InterruptedException {
        pages.getPagesHelper().renamePage("PAGE", 1);
    }

    @Test(priority = 5)
    public void renameUrl() throws InterruptedException {
        pages.getPagesHelper().renameUrl("/page-test", 1);
    }

    @Test(priority = 6)
    public void lockscreenPage() throws InterruptedException {
        pages.getPagesHelper().lockPages(1, "PAGE");
    }

    @Test(priority = 7)
    public void unlockPage() throws InterruptedException {
        pages.getPagesHelper().unlockPages("PAGE", 1);
    }
/*
    @Test(priority = 8)
    public void setAsHomePage() throws InterruptedException {
        pages.getPagesHelper().setAsHome("PAGE", 1);
    }

    @Test(priority = 9)
    public void ofAsHomePage() throws InterruptedException {
        pages.getPagesHelper().offAsHome("PAGE", 1);
    }
*/
    @Test(priority = 10)
    public void deletePage() throws Exception {
        pages.getPagesHelper().deletePages(1, "HOME");
    }

    @Test(priority = 9)
    public void goToMenu() throws InterruptedException {
        pages.getPagesHelper().goTo("design");
    }
}
