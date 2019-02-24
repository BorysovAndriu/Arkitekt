package io.arkitekt.mainWorker.operationsAdminPanel;

import io.arkitekt.mainWorker.operationBilling.BillingHelper;
import io.arkitekt.mainWorker.operationsMainSelenium.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteEditHelper extends HelperBase {

    public SiteEditHelper(WebDriver driver) {
        super(driver);
    }

    BillingHelper cancel = new BillingHelper(driver);

    public void createSite() throws InterruptedException {
        click(By.xpath("//*[@id=\"sites_list\"]/div/ul/li[1]/div/a"));
    }

    public void deleteSite() throws InterruptedException {
        click(By.xpath("//div[@class=\"site_delete\"]//button"));
        if (isElementDesplayed(By.xpath("//p[starts-with(text(),'Are you sure, you want to delete')]"))) {
            click(By.id("delete"));
        } else {
            click(By.xpath("//div[@id='delete_site_subscribed']//button[text()='Done']"));
            click(By.xpath("//div[@id='settings_site_general']//a[@href='#!/settings']"));
            click(By.xpath("//a[text()=\"Billing Info\"]"));
            cancel.cancelSubscribpition();
            //checking(("\n"+"SUBSCRIBE"),By.cssSelector("#billing_subscribe"), "textContent");
            click(By.xpath("//div[@id='settings_billing_info']//a[@href='#!/settings']"));
            click(By.xpath("//div[@class='left-block-item-inner settings active-menu']//li[2]/a"));
            click(By.xpath("//div[@class=\"site_delete\"]//button"));
            click(By.id("delete"));
        }
    }

    public int getSiteCount() {
        return driver.findElements(By.xpath("//div[@id='sites_list']/div/ul/li")).size();
    }
}
