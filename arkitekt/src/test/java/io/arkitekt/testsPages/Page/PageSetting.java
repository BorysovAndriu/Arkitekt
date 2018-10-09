package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class PageSetting extends TestBasePages {

    @Test(groups ={"PageSetting"}, priority = 1 )
    public void addPage() throws Exception {
        pages.getPagesHelper().addPages( "NEW PAGE", 1);
    }

    @Test(groups ={"PageSetting"}, priority = 2)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle("HOME", 1);
    }

    @Test(groups ={"PageSetting"},priority = 3)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("NEW PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 4)
    public void renamePage() throws InterruptedException {
        pages.getPagesHelper().renamePage("PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 5)
    public void renameUrl() throws InterruptedException {
        pages.getPagesHelper().renameUrl("/page-test", 1);
    }

    @Test(groups ={"PageSetting"},priority = 6)
    public void lockscreenPage() throws InterruptedException {
        pages.getPagesHelper().lockPages(1, "NEW PAGE");
    }

    @Test(groups ={"PageSetting"},priority = 7)
    public void unlockPage() throws InterruptedException {
        pages.getPagesHelper().unlockPages("PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 8)
    public void deletePage() throws Exception {
        pages.getPagesHelper().deletePages(1, "HOME");
    }
}
