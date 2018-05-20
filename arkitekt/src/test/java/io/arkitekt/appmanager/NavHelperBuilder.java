package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavHelperBuilder extends HelperBase{
    private WebDriver driver;

    public NavHelperBuilder(WebDriver driver) {
        super(driver);
    }

    public void movetoNavBuilder() {
        click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[2]/a/span"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[3]/a/span"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[4]/a/span"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[5]/a/span"));
        click(By.xpath("//nav[5]/div/h1/a/span[1]"));
    }

    public void movetoNavOutPreview() {
        click(By.xpath("//nav/div/div[1]/ul/li[1]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[2]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[3]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[4]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[5]/a"));
        click(By.xpath("//div/h1/a/span[1]"));
    }

    public void movetoNavpreview(){
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/home']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/about']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/tours']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/blog']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/reach-us']"));
    }



}