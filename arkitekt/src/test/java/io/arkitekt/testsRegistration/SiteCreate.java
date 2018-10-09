package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
  public void testCreateSite() throws Exception {
    if (! app.getSiteEditHelper().isElementPressent(By.cssSelector("#choose_template"))){
      app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
      app.getNavHelperLeftPanel().click(By.name("commit"));
      app.getNavHelperLeftPanel().initListSite(true);
      int after = app.getNavHelperLeftPanel().getCountSite();
      Assert.assertEquals(after,1);
    }
    else {
      app.getNavHelperLeftPanel().initListSite(true);
      int before = app.getNavHelperLeftPanel().getCountSite();
      app.getSiteEditHelper().createSite();
      app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
      app.getNavHelperLeftPanel().click(By.name("commit"));
      app.getNavHelperLeftPanel().initListSite(true);
      int after = app.getNavHelperLeftPanel().getCountSite();
      Assert.assertEquals(after, before+1);
    }
  }
}
