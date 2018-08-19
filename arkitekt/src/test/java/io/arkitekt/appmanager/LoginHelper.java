package io.arkitekt.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {

  public LoginHelper(WebDriver driver) {
    super(driver);
  }

  public void registr(RegistrData registrData) throws InterruptedException {
    type(registrData.getName(), By.id("user_first_name"));
    type(registrData.getEmail(), By.id("user_email"));
    type(registrData.getPassword(), By.id("user_password"));
    click(By.name("commit"));
  }

  public void logout() throws InterruptedException {
    click(By.name("commit"));
  }

}
