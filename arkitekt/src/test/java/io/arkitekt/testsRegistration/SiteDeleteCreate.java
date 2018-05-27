package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SiteDeleteCreate extends TestBase {

  @Test(priority = 1)
  public void testDeleteSite() throws Exception {

    app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
    app.getSiteEditHelper().deleteSite();
    app.getNavHelperLeftPanel().initListSite();
  }

  @Test(priority = 2)
  public void testCreateSite() throws Exception {

    if (! app.getSiteEditHelper().isElementPressent(By.cssSelector("#choose_template"))){
      app.getNavHelperLeftPanel().gotoMarathon();
      app.getNavHelperLeftPanel().click(By.name("commit"));
    }
    else {
      app.getNavHelperLeftPanel().initListSite();
      app.getSiteEditHelper().createSite();
      app.getNavHelperLeftPanel().gotoMarathon();
      app.getNavHelperLeftPanel().click(By.name("commit"));
    }

    app.getNavHelperLeftPanel().initListSite();
  }

}
