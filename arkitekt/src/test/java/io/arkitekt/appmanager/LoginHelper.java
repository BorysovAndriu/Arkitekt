package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase{

  public LoginHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String email, String password) {
    click(By.linkText("Sign in"));
    type(email, By.id("user_email"));
    type(password, By.id("user_password"));
    click(By.name("commit"));
  }

  public void logout() {
    click(By.name("commit"));
  }

}
