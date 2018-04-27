package io.arkitekt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SignIn {
  public WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://staging.arkitekt.io./");
    login("andriu.test.post.1@gmail.com", "1111111111");
  }

  private void login(String email, String password) {
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys(email);
    driver.findElement(By.id("user_password")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys(password);
    driver.findElement(By.name("commit")).click();
  }

  @Test
  public void testSignIn() throws Exception {
    initListSite();
   }


  public void initListSite() {
    driver.findElement(By.id("choose_template")).click();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }


}
