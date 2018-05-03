package io.arkitekt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LivePreview extends TestBase{

  @Test
  public void testLivePreview(){
    app.init("http://arkitekt.io./");
    app.getNavHelper().gotoGetStart();
    app.getNavHelper().gotoMarathon();
    app.getNavHelper().gotoLivePreview();
    app.getNavHelper().gotoTab();
    app.getNavHelper().waitForButtonSeconds(By.linkText("Explore tour"), 4);

  }
}
