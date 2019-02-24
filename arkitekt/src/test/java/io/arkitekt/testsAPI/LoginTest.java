package io.arkitekt.testsAPI;

import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBaseAPI{


    @Test
    public void Login() throws IOException {
        api.getHttpSession().loginPost();
    }


    @Test
    public void UploadFile() throws IOException {
        api.getHttpSession().uploadFileBanner();
    }


}
