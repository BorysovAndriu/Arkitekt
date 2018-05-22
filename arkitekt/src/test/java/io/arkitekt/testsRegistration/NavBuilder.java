package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavBuilder extends TestBase {

    @Test
    public void navBuiler() throws InterruptedException {
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperBuilder().movetoNavBuilder();
        app.getNavHelperBuilder().stopFrame();

    }

    @Test
    public void navPreview() throws InterruptedException {
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
        app.getNavHelperBuilder().hover(By.cssSelector("#hover_button_block"),
                                        By.cssSelector("By.cssSelector(\"#toggle_preview_icon\")"));
        app.getNavHelperBuilder().gotoFrame(By.xpath("//*[@id='page_preview_iframe']"));
        app.getNavHelperBuilder().movetoNavpreview();
    }
}

