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

    public void movetoNavBuilder() throws InterruptedException {
        gotoFrame(By.xpath("//div[3]/iframe[2]"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        checkingText("Explore the World",By.xpath("//div[@id='page_main_banner']//h4[text()='Explore the World']"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[2]/a/span"));
        checkingText("ABOUT", By.xpath("//*[@id=\"page_main_banner\"]//h5[text()='ABOUT']"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[3]/a/span"));
        click(By.xpath("//a[@href='2017-11-live-from-singapore']/button"));
        checkingText("Live from Singapore!", By.xpath("//div[@class='post_title']/h4"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[3]/a/span"));
        click(By.xpath("//a[@href='2017-4-on-the-road-canada']/button"));
        checkingText("On the Road: Canada", By.xpath("//div[@class='post_title']/h4"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[4]/a/span"));
        click(By.xpath("//a[@href='2017-10-lead-me-home']/button"));
// пропущено перевірку тайтлу посту
        click(By.xpath("//nav[5]/div/div[1]/ul/li[4]/a/span"));
        click(By.xpath("//a[@href='2017-10-a-journey-to-the-edge-of-the-world']/button"));
        checkingText("A Journey to the edge of the world", By.xpath("//div[@class='post_title']/h4"));
        click(By.xpath("//nav[5]/div/div[1]/ul/li[5]/a/span"));
        checkingText("GET IN TOUCH", By.xpath("//h1[text()='GET IN TOUCH']"));
        click(By.xpath("//nav[5]/div/h1/a/span[1]"));
        stopFrame();
    }

    public void movetoNavOutPreview() {
        click(By.xpath("//nav/div/div[1]/ul/li[1]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[2]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[3]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[4]/a"));
        click(By.xpath("//nav/div/div[1]/ul/li[5]/a"));
        click(By.xpath("//div/h1/a/span[1]"));
    }

    public void movetoNavpreview() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checkingText("Explore the World", By.xpath("//h4[text()='Explore the World']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/about']"));
        checkingText("ABOUT", By.xpath("//h5[text()='ABOUT']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/tours']"));
        click(By.xpath("//a[@href='2017-11-live-from-singapore']/button"));
        checkingText("Live from Singapore!", By.xpath("//div[@class='post_title']/h4"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/tours']"));
        click(By.xpath("//a[@href='2017-4-on-the-road-canada']/button"));
        checkingText("On the Road: Canada", By.xpath("//div[@class='post_title']/h4"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/blog']"));
        click(By.xpath("//a[@href='2017-10-lead-me-home']/button"));
        checkingText("LEAD ME HOME", By.xpath("//h1[text()='Lead Me Home']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/blog']"));
        click(By.xpath("//a[@href='2017-10-a-journey-to-the-edge-of-the-world']/button"));
        checkingText("A Journey to the edge of the world", By.xpath("//div[@class='post_title']/h4"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/reach-us']"));
        checkingText("GET IN TOUCH", By.xpath("//h1[text()='GET IN TOUCH']"));
        click(By.xpath("//div[@class='container']/div[1]//a[@href='/home']"));
        stopFrame();
    }



}