package io.arkitekt.testLogin;

import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends TestBaseLogin {

    @Test
    public void testLogin() throws InterruptedException, IOException {
        app1.getNavHelperLeftPanel().login("1111111111");
        app1.getNavHelperLeftPanel().writeCookies();
        app1.getNavHelperLeftPanel().initListSite(true);
    }
}
