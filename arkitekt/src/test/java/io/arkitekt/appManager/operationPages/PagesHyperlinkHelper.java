package io.arkitekt.appManager.operationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;

public class PagesHyperlinkHelper extends PagesBannerHelper {

    public PagesHyperlinkHelper(WebDriver driver) {
        super(driver);
    }

    public void openHyperlinkTab(int x) throws InterruptedException {
        openSettingPages(x);
        click(By.xpath("//a[@href='#page_hyperlink']"));
    }

    public void insertContentHyperlink(int x, String namePages, String Title) throws InterruptedException {
        openBannerTab(x);
        openEditWinHyperlink();
        //вибір Контент лінки
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[2]", hyperlinkID)));
        //вибір сторінки
        click(By.xpath("//ul[@id='pages_list_text_edit']/li[1]"));
        openNewWindow();
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));

        if(x!=22) {
            checkingBuilder("btn btn-default",
                    By.xpath("//div[@id='page_main_banner']//a[@class='btn btn-default']"), "className");
        } else {
            checkingBuilder("_blank",
                    By.xpath("//header[@class='page-main-banner-section']//a[@class='btn btn-default']"), "target");
        }

        checkingSubdomainOpenWin(x, Title);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertFileHyperlink(int x) throws InterruptedException, FileNotFoundException {
        openBannerTab(x);
        openEditWinHyperlink();
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[3]", hyperlinkID)));
        attachImage(By.xpath("//div[@id='edit_text_hyperlink_block']//input[@name='file']"),
                "src/test/resources/carBanner.jpg");
        click(By.xpath("(//div[starts-with(@id,'img_link_file')])[1]"));
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));

        if(x!=22) {
            checkingBuilder("btn btn-default",
                    By.xpath("//div[@id='page_main_banner']//a[@class='btn btn-default']"), "className");
        } else {
            checkingBuilder("_blank",
                    By.xpath("//header[@class='page-main-banner-section']//a[@class='btn btn-default']"), "target");
        }

        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));

        if(x!=22) {
            click(By.xpath("//header[@class='page-main-banner']//a"));
        } else {
            click(By.xpath("//header[@class='page-main-banner-section']//a"));
        }

        //don't work checking download file
        //File file = new File("C:\\Users\\Andrew\\Downloads\\carBanner.jpg");
        //file.exists();
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertExternalHyperlink(String Title, int x) throws InterruptedException {
        openBannerTab(x);
        openEditWinHyperlink();
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[4]", hyperlinkID)));
        type("https://www.google.com.ua/", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@placeholder='Paste URL here...']"));
        //openNewWindow();
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));

        if(x!=22) {
            checkingBuilder("btn btn-default",
                    By.xpath("//div[@id='page_main_banner']//a[@class='btn btn-default']"), "className");
        } else {
            checkingBuilder("_blank",
                    By.xpath("//header[@class='page-main-banner-section']//a[@class='btn btn-default']"), "target");
        }

        checkingSubdomainOpenWin(x, Title);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void insertNoneHyperlink(int x) throws InterruptedException {
        openBannerTab(x);
        openEditWinHyperlink();
        String hyperlinkID = getIdPage("data-activates", By.xpath("//div[@id='edit_text_hyperlink_block']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[1]", hyperlinkID)));
        click(By.xpath("//button[@class='btn btn-default btn-flat save-hyperlink waves-effect waves-button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkingBannerTextBuilder("  Banner", x);
        checkingBannerTextSubdomain("Banner", x);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void openNewWindow() throws InterruptedException {
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

    public void checkingSubdomainOpenWin(int x, String Title) throws InterruptedException {
        String winbefore = driver.getWindowHandle();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));

        if(x!=22) {
            click(By.xpath("//header[@class='page-main-banner']//a"));
        } else {
            click(By.xpath("//header[@class='page-main-banner-section']//a"));
        }

        stopFrame();
        for (String winNew : driver.getWindowHandles()) {
            driver.switchTo().window(winNew);
        }
        driver.getTitle().equals(Title);
        driver.close();
        driver.switchTo().window(winbefore);
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void insertContentLinkPage(int x) throws InterruptedException {
        openHyperlinkTab(x);
        //вибір Контент лінки
        String hyperlinkID = getIdPage("data-activates",
                By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[2]", hyperlinkID)));
        //вибір сторінки
        click(By.xpath("//div[@id='page_hyperlink']//ul[@id='pages_list_text_edit']/li[1]"));
        click(By.xpath("//div[@id='page_hyperlink']//span[@class='check']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkBuilderContentLinkPage("Home - Marathon");
        checkSubdomianContentLinkPage("Home - Marathon");
    }

    public void checkBuilderContentLinkPage(String Title) throws InterruptedException {
        String winbefore = driver.getWindowHandle();
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
        } else click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));

        for (String winNew : driver.getWindowHandles()) {
            driver.switchTo().window(winNew);
        }
        driver.getTitle().equals(Title);
        driver.close();
        driver.switchTo().window(winbefore);
        stopFrame();
    }

    public void checkSubdomianContentLinkPage(String Title) throws InterruptedException {
        String winbefore = driver.getWindowHandle();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
        } else click(By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));

        for (String winNew : driver.getWindowHandles()) {
            driver.switchTo().window(winNew);
        }
        driver.getTitle().equals(Title);
        driver.close();
        driver.switchTo().window(winbefore);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void insertFileLinkPage(int x) throws InterruptedException {
        openHyperlinkTab(x);
        String hyperlinkID = getIdPage("data-activates",
                By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[3]", hyperlinkID)));
        attachImage(By.xpath("//div[@id='page_hyperlink']//input[@name='file']"),
                "src/test/resources/carBanner.jpg");
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkBuilderFileLinkPage();
        checkSubdomianLinkPage();
    }

    public void checkBuilderFileLinkPage() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
        } else click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
        File file = new File("C:\\Users\\Andrew\\Downloads\\carBanner.jpg");
        file.exists();
        stopFrame();
    }

    public void checkSubdomianLinkPage() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
        } else click(By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));
        File file = new File("C:\\Users\\Andrew\\Downloads\\carBanner.jpg");
        file.exists();
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void insertExternalLinkPage(int x) throws InterruptedException {
        openHyperlinkTab(x);
        String hyperlinkID = getIdPage("data-activates",
                By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[4]", hyperlinkID)));
        type("https://www.google.com.ua/",
                By.xpath("//div[@id='page_hyperlink']//input[@placeholder='Paste URL here...']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkBuilderContentLinkPage("Google");
        checkSubdomianContentLinkPage("Google");
    }

    public void insertNoneLinkPage(int x) throws InterruptedException {
        openHyperlinkTab(x);
        String hyperlinkID = getIdPage("data-activates",
                By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath("//div[@id='page_hyperlink']//input[@value='None']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[1]", hyperlinkID)));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkingBuilderNoneLinkPage();
        checkingSubdomian();
    }

    public void checkingSubdomian() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            checking("javascript:undefined;", By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"), "href");
        } else
            checking("javascript:undefined;", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"), "href");


        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingBuilderNoneLinkPage() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            checking("javascript:undefined;", By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"), "href");
        } else
        checking("javascript:undefined;", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"), "href");
        stopFrame();
    }
}
