package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class PageBackground extends TestBasePages {

    @Test(priority = 1)
    public void addPage() throws Exception {
        app.getPagesHelper().addPages("NEW PAGE", 1);
    }

    @Test(priority = 2)
    public void addBackgroundColor() throws InterruptedException {
        app.getPagesHelper().backgroundColor(1);
    }

    @Test(priority = 3)
    public void addBackgroundImage() throws InterruptedException {
        app.getPagesHelper().addBackgroundImage(1);
    }

    @Test(priority = 4)
    public void addBackgroundImageOverlay() throws InterruptedException {
        app.getPagesHelper().addBackgroundImageOverlay(1);
    }

    @Test(priority = 5)
    public void addBackgroundImageScalingFit() throws InterruptedException {
        app.getPagesHelper().ImageScalingFit(1);
    }

    @Test(priority = 6)
    public void addBackgroundImageScalingPattern() throws InterruptedException {
        app.getPagesHelper().ImageScalingPattenr(1);
    }

    @Test(priority = 7)
    public void addBackgroundImageScalingFill() throws InterruptedException {
        app.getPagesHelper().ImageScalingFill(1);
    }

    @Test(priority = 8)
    public void addBackgroundImageScrollingEffectFix() throws InterruptedException {
        app.getPagesHelper().ScrollingEffectFix(1);
    }

    @Test(priority = 9)
    public void addBackgroundImageScrollingEffectNone() throws InterruptedException {
        app.getPagesHelper().ScrollingEffectNone(1);
    }

    @Test(priority = 10)
    public void deleteBackgroundImage() throws InterruptedException {
        app.getPagesHelper().deleteBackgroundImage(1);
    }

    @Test(priority = 11)
    public void resetBackgroundColor() throws InterruptedException {
        app.getPagesHelper().resetToDefaultBackgroundColor(1);
    }

    @Test(priority = 12)
    public void deletePage() throws Exception {
        app.getPagesHelper().deletePages(1, "HOME");
    }
}
