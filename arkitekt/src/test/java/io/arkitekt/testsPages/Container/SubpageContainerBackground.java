package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class SubpageContainerBackground extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        pages.getPagesHelper().addPages("NEW CONTAINER", 2);
    }

    @Test(priority = 2)
    public void addSubpageContainer() throws Exception {
        pages.getPagesHelper().addSubPage(22);
    }

    @Test(priority = 3)
    public void addBackgroundColor() throws InterruptedException {
        pages.getBackgroundHelper().backgroundColor(22);
    }

    @Test(priority = 4)
    public void addBackgroundImage() throws InterruptedException {
        pages.getBackgroundHelper().addBackgroundImage(22);
    }

    @Test(priority = 5)
    public void addBackgroundImageOverlay() throws InterruptedException {
        pages.getBackgroundHelper().addBackgroundImageOverlay(22);
    }

    @Test(priority = 6)
    public void addBackgroundImageScalingFit() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingFit(22);
    }

    @Test(priority = 7)
    public void addBackgroundImageScalingPattern() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingPattenr(22);
    }

    @Test(priority = 8)
    public void addBackgroundImageScalingFill() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingFill(22);
    }

    @Test(priority = 9)
    public void addBackgroundImageScrollingEffectFix() throws InterruptedException {
        pages.getBackgroundHelper().ScrollingEffectFix(22);
    }

    @Test(priority = 10)
    public void addBackgroundImageScrollingEffectNone() throws InterruptedException {
        pages.getBackgroundHelper().ScrollingEffectNone(22);
    }

    @Test(priority = 11)
    public void deleteBackgroundImage() throws InterruptedException {
        pages.getBackgroundHelper().deleteBackgroundImage(22);
    }

    @Test(priority = 12)
    public void resetBackgroundColor() throws InterruptedException {
        pages.getBackgroundHelper().resetToDefaultBackgroundColor(22);
    }

    @Test(priority = 13)
    public void deleteContainer() throws Exception {
        //pages.getPagesHelper().deletePages(22, "NEW CONTAINER");
        pages.getPagesHelper().deletePages(2, "HOME");
    }
}
