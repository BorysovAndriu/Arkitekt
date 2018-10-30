package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class SubPageDropDownSetting extends TestBasePages {
/*
    @Test(priority = 1)
    public void addDropDown() throws Exception {
        pages.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 2)
    public void addSubDropDown() throws Exception {
        pages.getPagesHelper().addSubPage(33);
    }

    @Test (priority = 3)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle( "", 33);
    }
*/
    @Test(priority = 4)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("", 33);
    }

    @Test(priority = 5)
    public void renameSubPageDropDown() throws InterruptedException {
        pages.getPagesHelper().renamePage( "SUBDROP", 33);
    }

    @Test(priority = 6)
    public void renameUrl() throws InterruptedException {
        pages.getPagesHelper().renameUrl("/subdrop-test", 33);
    }

    @Test(priority = 7)
    public void lockscreenSubPageDropDownr() throws InterruptedException {
        pages.getPagesHelper().lockPages(33, "");
    }

    @Test(priority = 8)
    public void unlocksubPageDropDown() throws InterruptedException {
        pages.getPagesHelper().unlockPages("SUBCONT", 33);
    }

    @Test(priority = 9)
    public void deleteSubDropDown() throws Exception {
        pages.getPagesHelper().deletePages(33, "");
    }

    @Test(priority = 10)
    public void deleteDropDown() throws Exception {
        pages.getPagesHelper().deletePages(3, "HOME");
    }
}
