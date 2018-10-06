package io.arkitekt.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelperLeftPanel extends HelperBase {
    private WebDriver driver;

    public NavHelperLeftPanel(WebDriver driver) {
        super(driver);
    }

    public void logo() throws InterruptedException {
        click(By.xpath("//div[@id='content']/div/div/a"));
    }

    public void gotoGetStart() throws InterruptedException {
        click(By.xpath("//a[text()='Get started']"));
    }

    public void gotoMarathon() throws InterruptedException {
        click(By.xpath("//img[@alt='Serenade']"));
    }

    public void initListSite(boolean collapse) throws InterruptedException {
        if (collapse == true) {
            while (isElementPressent(By.cssSelector("#choose_template[aria-expanded=\"false\"]"))) {
                click(By.cssSelector("#choose_template"));
            }
        } else {
            while (isElementPressent(By.cssSelector("#choose_template[aria-expanded=\"true\"]"))) {
                click(By.cssSelector("#choose_template"));
            }
        }
    }

        public void gotoSettingSiteGeneraInfo () throws InterruptedException {
            click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
            click(By.xpath("//div[@class='left-block-item-inner settings active-menu']//li[2]/a"));
        }

        public int getCountSite () {
            return driver.findElements(By.xpath("/div[@id='sites_list']//li[@class='data-created_at']")).size();
        }
    }
