package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUp extends TestBase {

  @Test()
  public void testSignUp() {
    app.getNavHelper().openSite("http://staging.arkitekt.io/");
    app.getNavHelper().click(By.xpath("//a[@class='btn btn-link']"));
    app.getNavHelper().click(By.xpath("//*[@id=\"new_user\"]/div/a[@class='btn-simple']"));
    app.getNavHelper().gotoMarathon();
    app.getNavHelper().click(By.xpath("//div/form/input[@name='commit']"));
    app.getLoginHelper().registr("andriu","andriu"+format.format(date)+"@gmail.com", "1111111111");
    app.getNavHelper().initListSite();
  }
}
