package io.arkitekt.appManager.testsSite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
  public void testCreateSite() throws Exception {
    if (! app.getSiteEditHelper().isElementPresent(By.cssSelector("#choose_template"))){
      app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));

      app.getNavHelperLeftPanel().initListSite(true);
      int oneSitemustBe = app.getNavHelperLeftPanel().getCountSite();
      app.getNavHelperLeftPanel().initListSite(false);
      Assert.assertEquals(oneSitemustBe,1);
    }
    else {
      app.getNavHelperLeftPanel().initListSite(true);
      int before = app.getNavHelperLeftPanel().getCountSite();
      app.getSiteEditHelper().createSite();
      app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));

      app.getNavHelperLeftPanel().initListSite(true);
      int after = app.getNavHelperLeftPanel().getCountSite();
      app.getNavHelperLeftPanel().initListSite(false);
      Assert.assertEquals(after, before+1);
    }
  }
}
