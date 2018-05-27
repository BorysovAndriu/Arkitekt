package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {

  public LoginHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String email, String password) {
    click(By.xpath("//a[@class='btn btn-link']"));
    type(email, By.id("user_email"));
    type(password, By.id("user_password"));
    click(By.name("commit"));
  }

  public void registr(String name, String email, String password) {
    type(name, By.id("user_first_name"));
    type(email, By.id("user_email"));
    type(password, By.id("user_password"));
    click(By.name("commit"));
  }



  public void logout() {
    click(By.name("commit"));
  }

}
