package io.arkitekt.testsAPI;

import io.arkitekt.API.ApiManager;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


public class TestBaseAPI {

    protected static final ApiManager api = new ApiManager();

    @BeforeMethod
    public void init() throws IOException {
        api.init();
    }

}
