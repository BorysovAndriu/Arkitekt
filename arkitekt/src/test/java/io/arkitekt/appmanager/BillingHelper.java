package io.arkitekt.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BillingHelper extends HelperBase {

    public BillingHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoSettingBilling() throws InterruptedException {
        click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
        click(By.xpath("//a[text()=\"Billing Info\"]"));
    }

    public void gotoSettingBillingExpired() throws InterruptedException {
        click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[1]/a"));
        click(By.xpath("//a[text()=\"Billing Info\"]"));
    }

    public void gotoSubscribpition() throws InterruptedException {
        click(By.id("billing_subscribe"));
    }

    public void chooseSubscribtionPrice() throws InterruptedException {
        gotoSubscribpition();
        gotoFrame(By.cssSelector("#new_subscription_iframe"));
        click(By.xpath("//label[@for='subscription_price_id_2']"));
        stopFrame();
    }

    public void cancelSubscribpition() throws InterruptedException {
        click(By.xpath("//a[@href='#!/settings/billing-info/cancel-subscription']"));
        click(By.xpath("//input[@value='CONFIRM']"));
        click(By.cssSelector("#cancel_subscription"));
    }

    public void changeCycle() throws InterruptedException {
        click(By.xpath("//*[@id='settings_billing_info']//input"));
        click(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li[2]/span"));
        click(By.xpath("//div[@id='settings_billing_info']//button[@tabindex='-1']"));
    }

    public void fillCheckout(BillingData billingData, boolean checkout) throws InterruptedException {
        if (checkout == true) {
            gotoFrame(By.cssSelector("#new_subscription_iframe"));
        } else {
            clickA(By.xpath("//a[@class='settings-billing-link']"));
            gotoFrame(By.xpath("//iframe[@class='subscribe_iframe']"));
        }
        type(billingData.getName(), By.xpath("//input[@name='subscription[card_holder_name]']"));
        type(billingData.getCard(), By.xpath("//input[@class='credit-card-number']"));
        type(billingData.getMonth(), By.xpath("//input[@class='exp_month']"));
        type(billingData.getYear(), By.xpath("//input[@class='exp_year']"));
        if (checkout == true) {
            type(billingData.getCvv(), By.xpath("//input[@class='credit-card-cvv']"));
        } else {
            type(billingData.getCvv(), By.xpath("//input[@data-stripe='cvv']"));
        }
        if (checkout == true) {
            click(By.xpath("//button[@name='button']"));
        } else {
            click(By.xpath("//input[@value='UPDATE PAYMENT INFO']"));
        }
        stopFrame();
    }

    public void checkingBillingCycle(String billingCycle) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String curentDate = format.format(date);
        Calendar calendar = new GregorianCalendar();

        if (billingCycle == "Monthly") {
            checking(("\n\r" + curentDate), By.xpath("//div[@class='clear-md']/following-sibling::*[1][@class='pull-right settings-billing-date']"),
                    "textContent");
            calendar.add(Calendar.MONTH, 1);
            String afterMonth = format.format(calendar.getTime());
        } else if (billingCycle == "Annual") {
            checking(("\n\r" + curentDate), By.xpath("//div[@class='clear-md']/following-sibling::*[1][@class='pull-right settings-billing-date']"),
                    "textContent");
            calendar.add(Calendar.MONTH, 1);
            String afterMonth = format.format(calendar.getTime());
<<<<<<< HEAD
            checking(("\n" + afterMonth), By.xpath("//div[@id='next_payment_date']"), "textContent");
=======
            checking(("\n\r" + afterMonth), By.xpath("//div[@id='next_payment_date']"), "textContent");
>>>>>>> master
            //метод зафейлиця якщо запускати тест повторно підписку сайту через деякий час (день два ...).
        }
    }
}
