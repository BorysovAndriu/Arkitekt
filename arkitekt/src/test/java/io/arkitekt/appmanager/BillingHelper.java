package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingHelper extends HelperBase{

    public BillingHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoSettingBilling() throws InterruptedException {
        click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
        click(By.xpath("//li//a[@href='#!/settings/billing-info']"));
        Thread.sleep(2000);
    }

    public void cancelSubscribpition() throws InterruptedException {
        click(By.xpath("//a[@href='#!/settings/billing-info/cancel-subscription']"));
        Thread.sleep(2000);
        click(By.xpath("//input[@value='CONFIRM']"));
    }

    public void changeCycle() throws InterruptedException {
        Thread.sleep(5000);
        click(By.xpath("//*[@id='settings_billing_info']//input"));
        click(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li[2]/span"));
        click(By.xpath("//div[@id='settings_billing_info']//button[text()]"));
    }

    public void gobackBillingInfo() {
        click(By.xpath("//div[@id='settings_billing_info']//a[@href='#!/settings']"));
        click(By.xpath("//h4[text()='Settings']/parent::div/a"));

    }
}
