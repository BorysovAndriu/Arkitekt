package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
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
