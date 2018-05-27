package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavBuilder extends TestBase {

    @Test
    public void navBuiler() throws InterruptedException {

        app.getNavHelperLeftPanel().gotoFrame(By.xpath("//div[3]/iframe[2]"));
        app.getNavHelperBuilder().movetoNavBuilder();
        app.getNavHelperBuilder().stopFrame();

    }

    @Test
    public void navPreview() throws InterruptedException {

        app.getNavHelperBuilder().hover(By.cssSelector("#hover_button_block"),
                                        By.cssSelector("By.cssSelector(\"#toggle_preview_icon\")"));
        app.getNavHelperBuilder().gotoFrame(By.xpath("//*[@id='page_preview_iframe']"));
        app.getNavHelperBuilder().movetoNavpreview();
    }
}

