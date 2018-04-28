package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
  private WebDriver driver;

  public LoginHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void login(String email, String password) {
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys(email);
    driver.findElement(By.id("user_password")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys(password);
    driver.findElement(By.name("commit")).click();
  }

  public void logout() {
    driver.findElement(By.name("commit")).click();
  }

}
