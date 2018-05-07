package io.arkitekt.testsRegistration;

import org.testng.annotations.Test;

public class LivePreview extends TestBase{

  @Test
  public void testLivePreview() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://arkitekt.io/");
    app.getNavHelperLeftPanel().gotoGetStart();
    app.getNavHelperLeftPanel().gotoMarathon();
    app.getNavHelperLeftPanel().gotoTab();
    app.getNavHelperBuilder().closeTab();

  }
}
