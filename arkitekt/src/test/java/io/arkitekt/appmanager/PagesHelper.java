package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagesHelper extends HelperBase{

    public PagesHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoAddPages(By locator) {
        click(By.xpath("//li//a[@href='#!/pages']"));
        click(By.xpath("//button[@id='sb5_add_new_page']"));
        click(locator);
    }

    public void addSubPagesC() throws InterruptedException {
        click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]/a"));
        checking("New Page", By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]/div[1]//input"));
        gotoFrame(By.xpath("//div[3]/iframe[2]"));
        checkingText("This page is empty.", By.xpath("//section[@class='page-section']//p"));
        stopFrame();
    }

    public void addSubPagesD() throws InterruptedException {
        click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]/a"));
        checking("New Page", By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]/div[1]//input"));
        gotoFrame(By.xpath("//div[3]/iframe[2]"));
        checkingText("This page is empty.", By.xpath("//div[@class='sb5-empty-drag-help']/p"));
        stopFrame();
    }
}
