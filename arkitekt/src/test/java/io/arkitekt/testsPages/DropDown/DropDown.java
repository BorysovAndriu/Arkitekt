package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DropDown extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        app.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 2)
    public void toggleOff() throws InterruptedException {
        app.getPagesHelper().toggle("HOME", 3);
    }

    @Test(priority = 3)
    public void toggleOn() throws InterruptedException {
        app.getPagesHelper().toggle("NEW DROPDOWN", 3);
    }

    @Test(priority = 3)
    public void renameDropDown() throws InterruptedException {
        app.getPagesHelper().renamePage( "DROP", 3);
    }

    @Test(priority = 4)
    public void renameSubDropDown() throws InterruptedException {
        app.getPagesHelper().renamePage
                ("SUBPAGE", 33);
    }

    @Test(priority = 5)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deletePages(3, "HOME");
    }
}
