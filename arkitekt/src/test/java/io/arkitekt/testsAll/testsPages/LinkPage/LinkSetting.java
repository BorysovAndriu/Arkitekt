package io.arkitekt.testsAll.testsPages.LinkPage;

import io.arkitekt.testsAll.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class LinkSetting extends TestBasePages {

    @Test(priority = 1)
    public void addLink() throws Exception {
        pages.getPagesHelper().addPages( "NEW LINK", 4);
    }

    @Test(priority = 2)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle("HOME", 4);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("NEW LINK", 4);
    }

    @Test(priority = 4)
    public void renamePage() throws InterruptedException {
        pages.getPagesHelper().renamePage( "LINK", 4);
    }

    @Test(priority = 5)
    public void deleteLink() throws Exception {
        pages.getPagesHelper().deletePages(4, "HOME");
    }
}
