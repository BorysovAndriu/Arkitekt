package io.arkitekt.testPreviewSite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class PreviewSite extends TestBasePreview {

    @Test(priority = 1)
    public void previewMarathon() throws Exception {
        app1.getNavHelperLeftPanel().previewThemes(By.xpath("//img[@alt='Marathon']"));
    }

    @Test(priority = 2)
    public void previewSerenade() throws Exception {
        app1.getNavHelperLeftPanel().previewThemes(By.xpath("//img[@alt='Serenade']"));
    }

    @Test(priority = 3)
    public void previewHoodie() throws Exception {
        app1.getNavHelperLeftPanel().previewThemes(By.xpath("//img[@alt='Hoodie']"));
    }

    @Test(priority = 4)
    public void previewWaves() throws Exception {
        app1.getNavHelperLeftPanel().previewThemes(By.xpath("//img[@alt='Waves']"));
    }
/*
    @Test(priority = 5)
    public void previewMarine() throws Exception {
        app1.getNavHelperLeftPanel().previewThemes(By.xpath("//img[@alt='Marine']"));
    }
    */
}
