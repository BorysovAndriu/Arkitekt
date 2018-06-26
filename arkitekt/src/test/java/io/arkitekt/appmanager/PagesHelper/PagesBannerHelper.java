package io.arkitekt.appmanager.PagesHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PagesBannerHelper extends PagesHelper {

    public PagesBannerHelper(WebDriver driver) {
        super(driver);
    }

    public void openBannerTab() {
       click(By.xpath("//a[@href='#page_banner']"));
    }

    public void addImage() {
        openSettingPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        openBannerTab();
        attachImage(By.xpath("//input[@name='banner_tmp_image_file']"),"src/test/resources/2.jpg");
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void deleteImage() {
        openSettingPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        openBannerTab();
        click(By.xpath("//a[@class='uploaded-banner-image-delete waves-effect']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void deleteBannerText() throws InterruptedException {
        openSettingPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        openBannerTab();
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        click(By.xpath("//body[@id='tinymce']"));
        driver.findElement(By.xpath("//body[@id='tinymce']")).
                sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.DELETE);
        stopFrame();
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void addBannerText() throws InterruptedException {
        openSettingPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        openBannerTab();
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        type("Banner", By.xpath("//body[@id='tinymce']"));
        stopFrame();
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void moveBannerHeight() throws InterruptedException {
        openSettingPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        openBannerTab();
        slider(By.xpath("//div[@id='banner_height_slider']"),
                By.xpath("//div[@id='banner_height_slider']//div[@class='noUi-handle noUi-handle-lower']"),
                -200, 0);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertHyperlink(String type) throws InterruptedException {
        openSettingPages(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"));
        openBannerTab();
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        click(By.xpath("//body[@id='tinymce']"));
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        stopFrame();
        //клік по едіторі на гіперлінку
        click(By.xpath("//div[@id='mceu_15']//i"));
        //клік по дропдаун для вибору типу гіперлінки

        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']//*[text()='%s']",hyperlinkID,type)));
        click(By.xpath("//div[@id='edit_text_hyperlink_block']//following::div[@id='choose_link_content_text']//following-sibling::div//span[@class='check']"));
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));

        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }






}
