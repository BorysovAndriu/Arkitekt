package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}