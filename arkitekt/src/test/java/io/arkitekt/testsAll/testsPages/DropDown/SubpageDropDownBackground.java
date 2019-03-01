package io.arkitekt.testsAll.testsPages.DropDown;

import io.arkitekt.testsAll.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class SubpageDropDownBackground extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        pages.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 2)
    public void addSubDropDown() throws Exception {
        pages.getPagesHelper().addSubPage(33);
    }

    @Test(priority = 3)
    public void addBackgroundColor() throws InterruptedException {
        pages.getBackgroundHelper().backgroundColor(33);
    }

    @Test(priority = 4)
    public void addBackgroundImage() throws InterruptedException {
        pages.getBackgroundHelper().addBackgroundImage(33);
    }

    @Test(priority = 5)
    public void addBackgroundImageOverlay() throws InterruptedException {
        pages.getBackgroundHelper().addBackgroundImageOverlay(33);
    }

    @Test(priority = 6)
    public void addBackgroundImageScalingFit() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingFit(33);
    }

    @Test(priority = 7)
    public void addBackgroundImageScalingPattern() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingPattenr(33);
    }

    @Test(priority = 8)
    public void addBackgroundImageScalingFill() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingFill(33);
    }

    @Test(priority = 9)
    public void addBackgroundImageScrollingEffectFix() throws InterruptedException {
        pages.getBackgroundHelper().ScrollingEffectFix(33);
    }

    @Test(priority = 10)
    public void addBackgroundImageScrollingEffectNone() throws InterruptedException {
        pages.getBackgroundHelper().ScrollingEffectNone(33);
    }

    @Test(priority = 11)
    public void deleteBackgroundImage() throws InterruptedException {
        pages.getBackgroundHelper().deleteBackgroundImage(33);
    }

    @Test(priority = 12)
    public void resetBackgroundColor() throws InterruptedException {
        pages.getBackgroundHelper().resetToDefaultBackgroundColor(33);
    }

    @Test(priority = 13)
    public void deleteDropDown() throws Exception {
        //pages.getPagesHelper().deletePages(33, "NEW DROPDOWN");
        pages.getPagesHelper().deletePages(3, "HOME");
    }
}
