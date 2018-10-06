package io.arkitekt.appManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrData {

    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd");

    private String name = "Andriu";
    private String email = "andriu"+format.format(date)+"@gmail.com";
    private String password = "1111111111";

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
