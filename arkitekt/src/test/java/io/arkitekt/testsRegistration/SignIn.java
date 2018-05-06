package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignIn extends TestBase {

  @Test
  public void testSignIn() throws Exception {
    app.getNavHelper().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelper().initListSite();
    //app.getLoginHelper().logout();
    //app.getNavHelper().logo();
  }

  @Test
  public  void testTrialSite(){
    app.getNavHelper().gotoFrame(By.cssSelector(".block-iframe"));
    app.getNavHelper().click(By.cssSelector("body.font-navbar-brand-Ambroise.font-navbar-nav-Montserrat.font-Raleway.content-show:nth-child(2) nav.active_navbar.fixed_strip.navTonB.navbar.right_side.rightbar.top_bar.transparent_strip.withstrip.affix-top:nth-child(10) div.container h1.navbar-header.col-sm-12.no-padding-sides.no-margin-sides-vertical.inline-block:nth-child(1) a.navbar-brand.inline-block > span.logo-text"));
  }

}
