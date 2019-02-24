package io.arkitekt.API;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApiManager {

    private Properties properties;
    private HttpSession http;

    public ApiManager() {
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        http = new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public HttpSession getHttpSession() {
        return http;
    }

}

