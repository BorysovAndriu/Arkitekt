package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class DropDown extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        pages.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 2)
    public void toggleOff() throws InterruptedException {
        pages.getPagesHelper().toggle("HOME", 3);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        pages.getPagesHelper().toggle("NEW DROPDOWN", 3);
    }

    @Test(priority = 3)
    public void renameDropDown() throws InterruptedException {
        pages.getPagesHelper().renamePage( "DROP", 3);
    }

    @Test(priority = 4)
    public void renameSubDropDown() throws InterruptedException {
        pages.getPagesHelper().renamePage
                ("SUBPAGE", 33);
    }

    @Test(priority = 5)
    public void deleteDropDown() throws Exception {
        pages.getPagesHelper().deletePages(3, "HOME");
    }
}
