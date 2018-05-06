package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LivePreview extends TestBase{

  @Test
  public void testLivePreview() throws InterruptedException {
    app.getNavHelper().openSite("http://arkitekt.io/");
    app.getNavHelper().gotoGetStart();
    app.getNavHelper().gotoMarathon();
    app.getNavHelper().gotoTab();

    //app.getNavHelper().click(By.cssSelector("nav.active_navbar.fixed_strip.navbar.right_side.rightbar.top_bar.transparent_strip.withstrip.affix-top:nth-child(4) div.container h1.navbar-header.col-sm-12.no-padding-sides.no-margin-sides-vertical.inline-block:nth-child(1) a.navbar-brand.inline-block > span.logo-text"));

  }
}
