package io.arkitekt.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
  public void testCreateSite() throws Exception {
    app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
    app.getNavHelper().initListSite();
    app.getSiteEditHelper().createSite();
    app.getNavHelper().gotoMarathon();
    app.getNavHelper().click(By.name("commit"));
    app.getNavHelper().initListSite();
  }

}

