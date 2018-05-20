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

  public void checkout(String fullname, String cardsNumber, String cvv, String expiresMM, String expiresYY) {
    type(fullname, By.xpath("//input[@name='subscription[card_holder_name]']"));
    type(cardsNumber, By.xpath("//input[@class='credit-card-number']"));
    type(cvv, By.xpath("//input[@class='credit-card-cvv']"));
    type(expiresMM, By.xpath("//input[@class='exp_month']"));
    type(expiresYY, By.xpath("//input[@class='exp_year']"));
    click(By.xpath("//button[@name='button']"));
  }

  public void logout() {
    click(By.name("commit"));
  }

}
