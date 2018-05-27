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

    public void gotoSubscribpition() {
        click(By.id("billing_subscribe"));
    }

    public void chooseSubscribtionPrice() throws InterruptedException {
        click(By.id("billing_subscribe"));
        gotoFrame(By.cssSelector("#new_subscription_iframe"));
        click(By.xpath("//label[@for='subscription_price_id_2']"));
        stopFrame();
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

    public void checkout(String fullname, String cardsNumber, String cvv, String expiresMM, String expiresYY) throws InterruptedException {
        gotoFrame(By.cssSelector("#new_subscription_iframe"));
        type(fullname, By.xpath("//input[@name='subscription[card_holder_name]']"));
        type(cardsNumber, By.xpath("//input[@class='credit-card-number']"));
        type(cvv, By.xpath("//input[@class='credit-card-cvv']"));
        type(expiresMM, By.xpath("//input[@class='exp_month']"));
        type(expiresYY, By.xpath("//input[@class='exp_year']"));
        click(By.xpath("//button[@name='button']"));
        stopFrame();
    }

    public void updatePaymentInfo(String fullname, String cardsNumber, String cvv, String expiresMM, String expiresYY) throws InterruptedException {
        clickA(By.xpath("//a[@class='settings-billing-link']"));
        gotoFrame(By.xpath("//iframe[@class='subscribe_iframe']"));
        type(fullname, By.xpath("//*[@id='payment-form']/div/div[2]/label/input"));
        type(cardsNumber, By.xpath("//input[@class='credit-card-number']"));
        type(expiresMM, By.xpath("//input[@class='exp_month']"));
        type(expiresYY, By.xpath("//input[@class='exp_year']"));
        type(cvv, By.xpath("//input[@data-stripe='cvv']"));
        click(By.xpath("//input[@value='UPDATE PAYMENT INFO']"));
        stopFrame();
    }
}
