package io.arkitekt.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelperLeftPanel extends HelperBase {

    public NavHelperLeftPanel(WebDriver driver) {
        super(driver);
    }

    public void logo() throws InterruptedException {
        click(By.xpath("//div[@class='navbar-header']//a[@href='/']"));
    }

    public void gotoGetStart() throws InterruptedException {
        click(By.xpath("//a[text()='Get started']"));
    }

    public void gotoThemes(By theme) throws InterruptedException {
        click(theme);
        click(By.name("commit"));
    }

    public void gotoSettingSiteGeneraInfo() throws InterruptedException {
        click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
        click(By.xpath("//div[@class='left-block-item-inner settings active-menu']//li[2]/a"));
    }

    public void previewThemes(By locator) throws InterruptedException {
        gotoGetStart();
        gotoThemes(locator);
        gotoTab();
        clickNavigation();
        closeTab();
        logo();
    }

}
