package io.arkitekt.appManager;

public class RegistrData {
    private final String name;
    private final String email;
    private final String password;

    public RegistrData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

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
