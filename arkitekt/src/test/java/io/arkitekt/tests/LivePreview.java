package io.arkitekt.tests;

import org.testng.annotations.Test;

public class LivePreview extends TestBase{

  @Test
  public void testLivePreview(){
    app.getNavHelper().gotoGetStart();
    app.getNavHelper().gotoMarathon();
    app.getNavHelper().gotoLivePreview();
  }
}
