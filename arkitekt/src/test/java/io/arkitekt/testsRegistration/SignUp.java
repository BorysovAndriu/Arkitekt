package io.arkitekt.testsRegistration;

import io.arkitekt.appManager.RegistrData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUp extends TestBasePreview {

    @Test
    //(priority = 1, enabled = false)
    public void testSignUp() throws InterruptedException {
        app1.getNavHelperLeftPanel().click(By.xpath("//a[@class='btn btn-link']"));
        app1.getNavHelperLeftPanel().click(By.xpath("//*[@id=\"new_user\"]/div/a[@class='btn-simple']"));
        app1.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
        app1.getNavHelperLeftPanel().click(By.xpath("//div/form/input[@name='commit']"));
        app1.getLoginHelper().
                registr(new RegistrData());
        app1.getNavHelperLeftPanel().initListSite(true);
    }
}
