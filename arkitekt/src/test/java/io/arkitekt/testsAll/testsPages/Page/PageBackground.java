package io.arkitekt.testsAll.testsPages.Page;

import io.arkitekt.testsAll.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class PageBackground extends TestBasePages {

    @Test(priority = 1)
    public void addPage() throws Exception {
        pages.getPagesHelper().addPages("NEW PAGE", 1);
    }

    @Test(priority = 2)
    public void addBackgroundColor() throws InterruptedException {
        pages.getBackgroundHelper().backgroundColor(1);
    }

    @Test(priority = 3)
    public void addBackgroundImage() throws InterruptedException {
        pages.getBackgroundHelper().addBackgroundImage(1);
    }

    @Test(priority = 4)
    public void addBackgroundImageOverlay() throws InterruptedException {
        pages.getBackgroundHelper().addBackgroundImageOverlay(1);
    }

    @Test(priority = 5)
    public void addBackgroundImageScalingFit() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingFit(1);
    }

    @Test(priority = 6)
    public void addBackgroundImageScalingPattern() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingPattenr(1);
    }

    @Test(priority = 7)
    public void addBackgroundImageScalingFill() throws InterruptedException {
        pages.getBackgroundHelper().ImageScalingFill(1);
    }

    @Test(priority = 8)
    public void addBackgroundImageScrollingEffectFix() throws InterruptedException {
        pages.getBackgroundHelper().ScrollingEffectFix(1);
    }

    @Test(priority = 9)
    public void addBackgroundImageScrollingEffectNone() throws InterruptedException {
        pages.getBackgroundHelper().ScrollingEffectNone(1);
    }

    @Test(priority = 10)
    public void deleteBackgroundImage() throws InterruptedException {
        pages.getBackgroundHelper().deleteBackgroundImage(1);
    }

    @Test(priority = 11)
    public void resetBackgroundColor() throws InterruptedException {
        pages.getBackgroundHelper().resetToDefaultBackgroundColor(1);
    }

    @Test(priority = 12)
    public void deletePage() throws Exception {
        pages.getBackgroundHelper().deletePages(1, "HOME");
    }
}
