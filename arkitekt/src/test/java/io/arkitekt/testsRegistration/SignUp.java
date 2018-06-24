package io.arkitekt.testsRegistration;

import io.arkitekt.appmanager.RegistrData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUp extends TestBase {

  @Test(priority = 1, enabled = false)
  public void testSignUp() throws InterruptedException {
    app.getNavHelperLeftPanel().click(By.xpath("//a[@class='btn btn-link']"));
    app.getNavHelperLeftPanel().click(By.xpath("//*[@id=\"new_user\"]/div/a[@class='btn-simple']"));
    app.getNavHelperLeftPanel().gotoMarathon();
    app.getNavHelperLeftPanel().click(By.xpath("//div/form/input[@name='commit']"));
    app.getLoginHelper().
            registr(new RegistrData("andriu", "andriu" + format.format(date) + "@gmail.com","1111111111"));
    app.getNavHelperLeftPanel().initListSite();
  }
}
