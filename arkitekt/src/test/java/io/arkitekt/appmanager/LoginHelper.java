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
    type(fullname, By.xpath("//*[@id=\"payment-form\"]/div[2]/div[2]/label/input"));
    type(cardsNumber, By.xpath("//*[@id=\"payment-form\"]/div[2]/div[3]/label[1]/input"));
    type(cvv, By.xpath("//*[@id=\"payment-form\"]/div[2]/div[3]/label[2]/input"));
    type(expiresMM, By.xpath("//*[@id=\"payment-form\"]/div[2]/div[4]/label/div/input[1]"));
    type(cvv, By.xpath("//*[@id=\"payment-form\"]/div[2]/div[4]/label/div/input[2]"));
    click(By.xpath("//*[@id=\"payment-form\"]/div[2]/div[5]/div/button"));
  }

  public void logout() {
    click(By.name("commit"));
  }

}
