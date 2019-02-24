package io.arkitekt.mainWorker.operationsAdminPanel;

import io.arkitekt.mainWorker.operationsMainSelenium.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavHelperLeftPanel extends HelperBase {

    @FindBy(xpath = "//ul[@class='list-unstyled menu']//a")
    public List<WebElement> mainMenu;



    public void goTo(String nameMenu) {

        for (int i = 0; i<mainMenu.size(); i++) {
            String urlMenu = mainMenu.get(i).getAttribute("hash");
            if(urlMenu == nameMenu) {
                mainMenu.get(i).click();
            } else break;
        }
    }

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
        //click(By.xpath("//a[@class='simple-btn ripple-btn']"));
    }

    public void gotoTheme(By theme) throws InterruptedException {
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

    public void openPasswordRecovery() throws InterruptedException {
        click(By.xpath(" //a[@class='pull-right forgot-password']"));
        type("user1@localhost.localdomain",By.xpath("//input[@id='send_input']"));
        click(By.xpath("//input[@id='btn_send']"));
        click(By.cssSelector("#modal_done"));
    }

    public void finish(String link, String password) throws InterruptedException {
        driver.get(link);
        type(password, By.cssSelector("#user_password"));
        type(password, By.cssSelector("#user_password_confirmation"));
        click(By.cssSelector("#new_user"));
    }

}
