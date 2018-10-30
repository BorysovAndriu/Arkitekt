package io.arkitekt.appManager.operationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class PagesBannerHelper extends PagesHelperBase {

    public PagesBannerHelper(WebDriver driver) {
        super(driver);
    }

    public void addImage(int x) throws InterruptedException {
        openBannerTab(x);
        attachImage(By.xpath("//input[@name='banner_tmp_image_file']"), "src/test/resources/carBanner.jpg");
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        //перевірка у білдері появи класу
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x==1 || x==2 || x==3 | x==33) {
            if (isElementPresent(By.xpath("//header[@class='active_banner page-main-banner']"))) {
                stopFrame();
            } else if (isElementPresent(By.xpath("//header[@class='page-main-banner active_banner']"))) {
                stopFrame();
            }
        } else if (x==22) {
            if (isElementPresent(By.xpath("//header[@class='page-main-banner-section']"))) {
                stopFrame();
            }
        }
        //перевірка в превю відображення банеру
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x==1 || x==2 || x==3) {
            if (isElementPresent(By.xpath("//header[@class='active_banner page-main-banner']"))
                    || isElementPresent(By.xpath("//header[@class='page-main-banner active_banner']"))) {
                stopFrame();
                hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
            }
        } else if (x==22) {
            if (isElementPresent(By.xpath("//header[@class='page-main-banner-section']"))) {
                stopFrame();
                hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
            }
        } else if (x==33) {
            if (isElementPresent(By.xpath("//header[@class='page-main-banner']/div[1]"))) {
                stopFrame();
                hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
            }
        }
        //вихід з розділу банер
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void deleteImage(int x) throws InterruptedException {
        openBannerTab(x);
        click(By.xpath("//a[@class='uploaded-banner-image-delete waves-effect']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x==1 || x==2 || x==3 || x==33) {
            if (isElementPresent(By.xpath("//header[@class='active_banner page-main-banner hidden']"))) {
                stopFrame();
            } else if (isElementPresent(By.xpath("//header[@class='page-main-banner active_banner hidden']"))) {
                stopFrame();
            }
        } else if (x==22) {
            if (isElementPresent(By.xpath("//header[@class='page-main-banner-section hidden']"))) {
                stopFrame();
            } else if (isElementPresent(By.xpath("//header[@class='hidden page-main-banner-section']"))) {
                stopFrame();
            }
        }
        //перевірка в превю відображення банеру
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x==1 || x==2 || x==3 || x==33) {
            if (isElementPresent(By.xpath("//nav[@class='active_navbar fixed_strip navTonB navbar right_side rightbar top_bar withstrip affix-top withoutbanner nonetransparent_strip']"))) {
                stopFrame();
                hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
            }
        } else if (x==22) {
            if (!isElementPresent(By.xpath("//header[@class='page-main-banner-section']"))) {
                stopFrame();
                hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
            }
        }
        //вихід з розділу банер
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void deleteBannerText(int x) throws InterruptedException {
        openBannerTab(x);
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        click(By.xpath("//body[@id='tinymce']"));
        driver.findElement(By.xpath("//body[@id='tinymce']")).
                sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        stopFrame();
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkingBannerTextBuilder(" ", x);
        checkingDeleteBannerTextSubdomain(" ", By.xpath("//div[@id='page_main_banner']//h4"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void addBannerText(int x) throws InterruptedException {
        openBannerTab(x);
        gotoFrame(By.xpath("//iframe[@id='banner_text_ifr']"));
        typeN("Banner", By.xpath("//body[@id='tinymce']"));
        stopFrame();
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkingBannerTextBuilder("Banner", x);
        checkingBannerTextSubdomain("Banner", x);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void moveBannerHeight(int x) throws InterruptedException {
        openBannerTab(x);
        slider(By.xpath("//div[@id='banner_height_slider']"),
                By.xpath("//div[@id='banner_height_slider']//div[@class='noUi-handle noUi-handle-lower']"),
                100, 0);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        //перевірка у білдері
        if(x!=22) {
            checkingBuilder("780", By.xpath("//div[@id='page_main_banner']"), "offsetHeight");
        } else {
            checkingBuilder("780", By.xpath("//header[@class='page-main-banner-section']"), "offsetHeight");
        }
        //перевірка в превю відображення банер тексту
        if(x!=22) {
            checkingSubdomian("780", By.xpath("//div[@id='page_main_banner']"), "offsetHeight");
        } else {
            checkingSubdomian("780", By.xpath("//header[@class='page-main-banner-section']"), "offsetHeight");
        }
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void checkingBannerTextBuilder(String bannerText, int x) throws InterruptedException {
        //перевірка у білдері
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x==2 || x==33) {
            if (isElementPresent(By.xpath("//header[@class='active_banner page-main-banner']"))) {
                String existingText = driver.findElement(By.xpath("//header[@class='active_banner page-main-banner']//h4[1]")).getText();
                assertEquals(bannerText, existingText);
            } else {
                String existingText = driver.findElement(By.xpath("//header[@class='page-main-banner active_banner']//h4[1]")).getText();
                assertEquals(bannerText, existingText);
            }
        } else if (x==22) {
            checkingText(bannerText, By.xpath("//header[@class='page-main-banner-section']//h4[1]"));
        }
        stopFrame();
    }

    public void checkingBannerTextSubdomain(String bannerText, int x) throws InterruptedException {
        //перевірка в превю відображення банер тексту
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x == 1 || x==2 || x==33) {
            checkingText(bannerText, By.xpath("//header[@class='page-main-banner']//h4[1]"));
        } else if (x==22) {
            checkingText(bannerText, By.xpath("//header[@class='page-main-banner-section']//h4[1]"));
        }
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingDeleteBannerTextSubdomain(String bannerText, By locator) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (!isElementPresent(locator)) {
            stopFrame();
            hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        }
    }

    public void checkingSubdomian(String checkText, By locator, String nameValue) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checking(checkText, locator, nameValue);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingBuilder(String checkText, By locator, String value) throws InterruptedException {
        //перевірка у білдері появи класу
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        checking(checkText, locator, value);
        stopFrame();
    }
}
