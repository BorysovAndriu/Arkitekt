package io.arkitekt.testsRegistration;

import io.arkitekt.mainWorker.operationsLogin.RegistrData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignUp extends TestBaseRegistration {

    @Test(priority = 1)
    public void testSignUp() throws InterruptedException, IOException {
        app1.getNavHelperLeftPanel().click(By.xpath("//a[@class='btn btn-link']"));
        app1.getNavHelperLeftPanel().click(By.xpath("//*[@id=\"new_user\"]/div/a[@class='btn-simple']"));
        app1.getNavHelperLeftPanel().gotoTheme(By.xpath("//img[@alt='Marathon']"));
        app1.getNavHelperLeftPanel().click(By.xpath("//div/form/input[@name='commit']"));
        app1.getLoginHelper().
                registr(new RegistrData());
        try {
            app1.getNavHelperLeftPanel().writeEmail();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app1.getNavHelperLeftPanel().writeCookies();
        app1.getNavHelperLeftPanel().initListSite(true);
    }
}
