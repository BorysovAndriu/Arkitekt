package io.arkitekt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SignIn {
  public WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignInLogout() throws Exception {
    driver.get("http://staging.arkitekt.io./");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("andriu.test.post.1@gmail.com");
    driver.findElement(By.id("user_password")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("1111111111");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.id("choose_template")).click();
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/div/a")).click();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }





}
