package io.arkitekt.appmanager.PagesHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;

public class PagesBannerHelper extends PagesHelper {

    public PagesBannerHelper(WebDriver driver) {
        super(driver);
    }

    public void openBannerTab(By locator) {
        openSettingPages(locator);
        click(By.xpath("//a[@href='#page_banner']"));
    }

    public void addImage(By locator) throws InterruptedException {
        openBannerTab(locator);
        attachImage(By.xpath("//input[@name='banner_tmp_image_file']"), "src/test/resources/carBanner.jpg");
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        //перевірка у білдері появи класу
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (isElementPressent(By.xpath("//header[@class='page-main-banner active_banner']"))) {
            checking("page-main-banner active_banner", By.xpath("//header[@class='page-main-banner active_banner']"), "className");
        } else {
            checking("active_banner page-main-banner", By.xpath("//header[@class='active_banner page-main-banner']"), "className");
        }
        stopFrame();
        //перевірка в превю відображення банеру
        checkingSubdomian("page-main-banner",
                By.xpath("//header[@class='page-main-banner']"), "className");
        //вихід з розділу банер
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void deleteImage(By locator) throws InterruptedException {
        openBannerTab(locator);
        click(By.xpath("//a[@class='uploaded-banner-image-delete waves-effect']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        chekingBuilder("active_navbar fixed_strip navTonB navbar right_side rightbar top_bar withstrip affix-top withoutbanner nonetransparent_strip", By.xpath("//nav[@class='active_navbar fixed_strip navTonB navbar right_side rightbar top_bar withstrip affix-top withoutbanner nonetransparent_strip']"), "className");
        checkingSubdomian("active_navbar fixed_strip navbar nonetransparent_strip right_side rightbar top_bar withstrip withoutbanner affix-top",
                By.xpath("//nav[@class='active_navbar fixed_strip navbar nonetransparent_strip right_side rightbar top_bar withstrip withoutbanner affix-top']"),
                "className");
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void deleteBannerText(By locator) throws InterruptedException {
        openBannerTab(locator);
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        click(By.xpath("//body[@id='tinymce']"));
        driver.findElement(By.xpath("//body[@id='tinymce']")).
                sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        stopFrame();
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkingBannerTextBuilder(" ");
        checkingDeleteBannerTextSubdomain(" ", By.xpath("//div[@id='page_main_banner']//h4"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void addBannerText(By locator) throws InterruptedException {
        openBannerTab(locator);
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        typeN("Banner", By.xpath("//body[@id='tinymce']"));
        stopFrame();
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkingBannerTextBuilder("  Banner");
        checkingBannerTextSubdomain("Banner", By.xpath("//div[@id='page_main_banner']//h4[2]"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void moveBannerHeight(By locator) throws InterruptedException {
        openBannerTab(locator);
        slider(By.xpath("//div[@id='banner_height_slider']"),
                By.xpath("//div[@id='banner_height_slider']//div[@class='noUi-handle noUi-handle-lower']"),
                -100, 0);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        //перевірка у білдері
        chekingBuilder("220", By.xpath("//div[@id='page_main_banner']"), "offsetHeight");
        //перевірка в превю відображення банер тексту
        checkingSubdomian("220", By.xpath("//div[@id='page_main_banner']"), "offsetHeight");
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertContentHyperlink(By locator, String namePages, String Title) throws InterruptedException {
        openBannerTab(locator);
        openEditWinHyperlink();
        //вибір Контент лінки
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[2]", hyperlinkID)));
        //вибір сторінки
        click(By.xpath("//ul[@id='pages_list_text_edit']/li[1]"));
        openNewWindow();
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        chekingBuilder("btn btn-default",
                By.xpath("//div[@id='page_main_banner']//a[@class='btn btn-default']"), "className");
        checkingSubdomainOpenWin(Title);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertFileHyperlink(By locator) throws InterruptedException, FileNotFoundException {
        openBannerTab(locator);
        openEditWinHyperlink();
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[3]", hyperlinkID)));
        attachImage(By.xpath("//div[@id='edit_text_hyperlink_block']//input[@name='file']"),
                "src/test/resources/carBanner.jpg");
        click(By.xpath("//div[@id='sb_text_file_list']/div/div[1]"));
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        chekingBuilder("btn btn-default",
                By.xpath("//div[@id='page_main_banner']//a[@class='btn btn-default']"), "className");
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        click(By.xpath("//header[@class='page-main-banner']//a"));
        File file = new File("C:\\Users\\Andrew\\Downloads\\carBanner.jpg");
        file.exists();
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertExtrenalHyperlink(By locator, String Title) throws InterruptedException {
        openBannerTab(locator);
        openEditWinHyperlink();
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[4]", hyperlinkID)));
        type("https://www.google.com.ua/", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@placeholder='Paste URL here...']"));
        //openNewWindow();
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        chekingBuilder("btn btn-default",
                By.xpath("//div[@id='page_main_banner']//a[@class='btn btn-default']"), "className");
        checkingSubdomainOpenWin(Title);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertNoneHyperlink(By locator) throws InterruptedException {
        openBannerTab(locator);
        openEditWinHyperlink();
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[1]", hyperlinkID)));
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkingBannerTextBuilder("  Banner");
        checkingBannerTextSubdomain("Banner", By.xpath("//header[@class='page-main-banner']//h4[2]"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void openNewWindow() {
        click(By.xpath("//div[@id='edit_text_hyperlink_block']//following::div[@id='choose_link_content_text']//following-sibling::div//span[@class='check']"));
    }

    public void openEditWinHyperlink() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        //виділення тексту
        doubleClick(By.xpath("//body[@id='tinymce']/h4[2]"));
        //driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        stopFrame();
        //клік по едіторі на гіперлінку

        click(By.xpath("//div[@id='page_options']//div[@class='mce-container-body mce-flow-layout']//div[1]/div[3]"));
        //клік по дропдаун для вибору типу гіперлінки
        click(By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
    }

    public void checkingBannerTextBuilder(String bannerText) throws InterruptedException {
        //перевірка у білдері
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (isElementPressent(By.xpath("//header[@class='active_banner page-main-banner']"))) {
            checkingText(bannerText, By.xpath("//header[@class='active_banner page-main-banner']"));
        } else {
            checkingText(bannerText, By.xpath("//header[@class='page-main-banner active_banner']"));
        }
        stopFrame();
    }

    public void checkingBannerTextSubdomain(String bannerText, By locator) throws InterruptedException {
        //перевірка в превю відображення банер тексту
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checkingText(bannerText, locator);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingDeleteBannerTextSubdomain(String bannerText, By locator) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if(!isElementPressent(locator)){
            stopFrame();
            hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));}
    }

    public void checkingSubdomian(String checkText, By locator, String nameValue) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checking(checkText, locator, nameValue);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingSubdomainOpenWin(String Title) throws InterruptedException {
        String winbefore = driver.getWindowHandle();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        click(By.xpath("//header[@class='page-main-banner']//a"));
        stopFrame();
        for (String winNew : driver.getWindowHandles()) {
            driver.switchTo().window(winNew);
        }
        driver.getTitle().equals(Title);
        driver.switchTo().window(winbefore);
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void chekingBuilder(String checkText, By locator, String value) throws InterruptedException {
        //перевірка у білдері появи класу
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        checking(checkText, locator, value);
        stopFrame();
    }

}
