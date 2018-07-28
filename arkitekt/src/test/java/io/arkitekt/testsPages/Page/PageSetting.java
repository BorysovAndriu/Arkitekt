package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PageSetting extends TestBasePages {

    @Test(groups ={"PageSetting"}, priority = 1 )
    public void addPage() throws Exception {
        app.getPagesHelper().addPages( "NEW PAGE", 1);
    }

    @Test(groups ={"PageSetting"}, priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggle("HOME", 1);
    }

    @Test(groups ={"PageSetting"},priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggle("NEW PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 4)
    public void renamePage() throws InterruptedException {
        app.getPagesHelper().renamePage("PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 5)
    public void renameUrl() throws InterruptedException {
        app.getPagesHelper().renameUrl("/page-test", 1);
    }

    @Test(groups ={"PageSetting"},priority = 6)
    public void lockscreenPage() throws InterruptedException {
        app.getPagesHelper().lockPages(1);
    }

    @Test(groups ={"PageSetting"},priority = 7)
    public void unlockPage() throws InterruptedException {
        app.getPagesHelper().unlockPages("PAGE", 1);
    }

    @Test(groups ={"PageSetting"},priority = 8)
    public void deletePage() throws Exception {
        app.getPagesHelper().deletePages(1, "HOME");
    }
}
