package io.arkitekt.appmanager.PagesHelper;

import io.arkitekt.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class PagesHelper extends HelperBase {

    public PagesHelper(WebDriver driver) {
        super(driver);
    }

    public By findPagesCards(int x) {
        By locator = By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]");
        String idFirstPage = getId(locator);
        if (x == 2) {
            checking("container", locator, "data-type");
            By container = By.xpath(String.format("//div[@id='%s']/div[1]", idFirstPage));
            return container;
        } else if (x == 22) {
            String idSubPage = getIdPage("id",
                    By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]", idFirstPage)));
            By subpage = By.xpath(String.format("//div[@id='%s']", idSubPage));
            checking("page", subpage, "data-type");
            By subpageContainer = By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]", idFirstPage));
            return subpageContainer;
        } else if (x == 1) {
            checking("page", locator, "data-type");
            By page = By.xpath(String.format("//div[@id='page-%s']/div[1]", idFirstPage));
            return page;
        } else if (x == 3) {
            checking("folder", locator, "data-type");
            By dropdown = By.xpath(String.format("//div[@id='page-%s']/div[1]", idFirstPage));
            return dropdown;
        } else if (x == 33) {
            String idSubPage = getIdPage("id",
                    By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]", idFirstPage)));
            By subpage = By.xpath(String.format("//div[@id='%s']", idSubPage));
            checking("page", subpage, "data-type");
            By subpageDropDown = By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]", idFirstPage));
            return subpageDropDown;
        } else if (x == 4) {
            checking("link", locator, "data-type");
            By link = By.xpath(String.format("//div[@id='page-%s']/div[1]", idFirstPage));
            return link;
        } else return locator;
    }

    public void addPages(String namePage, int x) throws InterruptedException {
        click(By.xpath("//button[@id='sb5_add_new_page']"));
        if (x == 1) {
            click(By.xpath("//a[@id='add_new_page']"));
        } else if (x == 2) {
            click(By.xpath("//a[@id='add_new_container']"));
        } else if (x == 3) {
            click(By.xpath("//a[@id='add_new_folder']"));
        } else if (x == 4) {
            click(By.xpath("//a[@id='add_new_link']"));
        }
        builderCheck(x, namePage);
        subdomainCheck(x, namePage);
    }

    public void addSubPage(int x) throws InterruptedException {
        if (x == 22) {
            click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
            builderCheck(x, "This page is empty." + "\n" + "Use the + button to add widgets.");
        } else if (x == 33) {
            click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
            builderCheck(x, "NEW PAGE");
            subdomainCheck(x, "NEW PAGE");
        }
    }

    public void deletePages(int x, String namePage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(findPagesCards(x)));
        new Actions(driver).
                moveToElement(driver.findElement(findPagesCards(x))).build().perform();
        if (x == 2 || x == 33 || x == 1) {
            findxPathDeleteIcon(x);
            click(By.xpath("//*[@id=\"menu_item_remove\"]"));
            if (x == 33) {
                assertFalse(driver.findElement(By.xpath("//ul[@style='display: block;']//span")).isDisplayed());
            } else {
                builderCheck(x, namePage);
                subdomainCheck(x, namePage);
            }
        } else if (x == 22 || x == 3 || x == 4) {
            findxPathDeleteIcon(x);
            if (x == 22) {
                assertFalse(driver.findElement(By.xpath("//p[@class='sb5-empty-text']")).isDisplayed());
            } else {
                builderCheck(x, namePage);
                subdomainCheck(x, namePage);
            }
        }
    }

    private void findxPathDeleteIcon(int x) throws InterruptedException {
        By xPathSimplePage = By.xpath((findPagesCards(x) + "//div[3]/button").substring(9).trim());
        By xPathContainerPage = By.xpath((findPagesCards(x) + "//div[4]/button").substring(9).trim());

        if (x == 1 || x == 4) { click(xPathSimplePage);
        } else if (x == 3 || x == 33 || x == 2) { click(xPathContainerPage);
        } else if (x == 22) {
            if (isElementDesplayed(xPathContainerPage)) { click(xPathContainerPage);
            } else { click(xPathSimplePage); }
        }
    }

    public void builderCheck(int x, String namePage) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x == 2 || x == 3 || x == 4 || x == 33) {
            if (isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
                click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
                if (x == 33) {
                    click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
                    checkingText(namePage, By.xpath("//ul[@style='display: block;']//span"));
                } else
                    checkingText(namePage, By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a/span"));
            } else {
                if (x == 33) {
                    click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
                    checkingText(namePage, By.xpath("//ul[@style='display: block;']//span"));
                } else
                    checkingText(namePage, By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
            }
        } else if (x == 22) {
            checkingText(namePage, By.xpath("//p[@class='sb5-empty-text']"));
        }
        stopFrame();
    }

    public void subdomainCheck(int x, String namePage) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x == 1 || x == 2 || x == 3 || x == 4 || x == 33) {
            if (isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
                click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
                if (x == 33) {
                    click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
                    checkingText(namePage, By.xpath("//ul[@style='display: block;']//span"));
                } else
                    checkingText(namePage, By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
            } else {
                if (x == 33) {
                    click(By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));
                    checkingText(namePage, By.xpath("//ul[@style='display: block;']//span"));
                } else checkingText(namePage, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));
            }
        } else if (x == 22) {
            checking("page-section", By.xpath("//section[@class='page-section']"), "className");
        }
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkLockSubdomain() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checkingText("PRIVATE PAGE", By.xpath("//h2[text()='PRIVATE PAGE']"));
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void toggle(String namePage, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        click(By.xpath("//input[@name='enable-page']/following-sibling::span"));
        if (isElementPressent(By.xpath("//input[@name='enable-page']/following-sibling::span[@class='toggle untoggled']"))) {
            if (x == 22) {
                builderCheck(x, "This page is empty." + "\n" + "Use the + button to add widgets.");
                subdomainCheck(x, "HOME");
            } else if (x == 1 || x == 2 || x == 3 || x == 4 || x == 33) {
                gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
                if (!isElementDesplayed(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"))) {
                    stopFrame();
                }
                subdomainCheck(x, "HOME");
            }
        } else if (isElementPressent(By.xpath("//input[@name='enable-page']/following-sibling::span[@class='toggle toggled']"))) {
            builderCheck(x, namePage);
            subdomainCheck(x, namePage);
        }
        Thread.sleep(5000);
        click(By.xpath("//a[@class='back-to-menu waves-circle waves-effect' and @href='#!/pages']"));
    }

    public void renamePage(String namePage, int x) throws InterruptedException {
        openSettingPages(x);
        rename(namePage, By.xpath("//input[@name='nav_title']"));
        builderCheck(x, namePage);
        subdomainCheck(x, namePage);
    }

    public void renameUrl(String nameUrl, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        rename(nameUrl, By.xpath("//*[@name='url' and @placeholder='newpage']"));
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checking(nameUrl, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"), "pathname");
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void rename(String text, By type) throws InterruptedException {
        Thread.sleep(5000);
        type(text, type);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void lockPages(int x) throws InterruptedException {
        openSettingPages(x);
        type("1111", By.xpath("//input[@name='password']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkingText("Extra Pages", By.xpath("//h5[text()='Extra Pages']"));
        checkLockSubdomain();
    }

    public void unlockPages(String namePage, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        click(By.xpath("//input[@name='password']"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.BACK_SPACE);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        subdomainCheck(x, namePage);
    }

    public void openSettingPages(int x) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(findPagesCards(x)));
        click(By.xpath("//*[@id='site_pages']/h5"));
        new Actions(driver).
                moveToElement(driver.findElement(findPagesCards(x))).click().build().perform();
    }

    public void openBackgroundTab(int x) throws InterruptedException {
        openSettingPages(x);
        click(By.xpath("//a[@href='#page_background']"));
    }

    public void ColorEditor(By locator, By field) throws InterruptedException {
        click(locator);
        driver.findElement(field).
                sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        type("#54E135", field);
        click (By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void backgroundColor(int x) throws InterruptedException {
        openBackgroundTab(x);
        ColorEditor(By.cssSelector("#page_background_color #colorPreview"),
                By.xpath("//input[@name='page_background_color']"));
        builderCheckBackground(x, "rgba(84, 225, 53, 1)");
    }

    public void resetToDefaultBackgroundColor(int x) throws InterruptedException {
        openBackgroundTab(x);
        click(By.cssSelector("#page_background_color #colorPreview"));
        click(By.xpath("//button[@id='background_reset_button']"));
        click (By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        builderCheckBackground(x, "transparent");
    }

    public void addBackgroundImage(int x) throws InterruptedException {
        openBackgroundTab(x);
        attachImage(By.xpath("//input[@name='background_tmp_image_file']"), "src/test/resources/background.jpg");
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkBuilderBackgroundImage();
    }

    public void deleteBackgroundImage(int x) throws InterruptedException {
        openBackgroundTab(x);
        click(By.xpath("//div[@id='background-page-image']//a"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkBuilderoffBackgroundImage();
    }

    public void checkBuilderBackgroundImage() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        Assert.assertTrue((driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                getCssValue("background-image")).length()>5, "none");
        stopFrame();
    }

    public void checkBuilderoffBackgroundImage() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        Assert.assertFalse((driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                getCssValue("background-image")).length()>5, "none");
        stopFrame();
    }

    public void addBackgroundImageOverlay(int x) throws InterruptedException {
        openBackgroundTab(x);
        ColorEditor(By.cssSelector("#page_background_image_overlay_color #colorPreview"),
                By.xpath("//input[@name='page_background_image_overlay_color']"));
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        String color = (driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                getCssValue("background-image"));
        String c = color.substring(0, 38);
        assertEquals(c, "linear-gradient(rgba(84, 225, 53, 0.3)");
        stopFrame();
    }

    public void chooseImageSetting(int x, String type, String openGroup) throws InterruptedException {
        openBackgroundTab(x);
        click(By.xpath(openGroup));
        click(By.xpath(type));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void ImageScalingFit(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group background_image_settings']//ul/li[2]",
                "//div[@class='form-group background_image_settings']//input");
        CheckBuilderScaling("background-repeat", "no-repeat, no-repeat");
    }

    public void ImageScalingPattenr(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group background_image_settings']//ul/li[3]",
                "//div[@class='form-group background_image_settings']//input");
        CheckBuilderScaling("background-repeat", "repeat, repeat");
    }

    public void ImageScalingFill(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group background_image_settings']//ul/li[1]",
                "//div[@class='form-group background_image_settings']//input");
        CheckBuilderScaling("background-size", "cover, cover");
    }

    public void ScrollingEffectFix(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group page-scrolling-effect background_image_settings']//ul/li[1]",
                "//div[@class='form-group page-scrolling-effect background_image_settings']//input");
        CheckBuilderScaling("background-attachment", "fixed, fixed");
    }

    public void ScrollingEffectNone(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group page-scrolling-effect background_image_settings']//ul/li[2]",
                "//div[@class='form-group page-scrolling-effect background_image_settings']//input");
        CheckBuilderScaling("background-attachment", "scroll, scroll");
    }

    public void CheckBuilderScaling(String valueName, String value) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        String repeat = driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                getCssValue(valueName);
        assertEquals(repeat, value);
        stopFrame();
    }

    public void builderCheckBackground(int x, String backgroundColor) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1  || x == 33) {
            String color= driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                    getCssValue("background-color");
            assertEquals(color, backgroundColor);
        } else if (x == 22) {
            String color= driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue("background-color");
            assertEquals(color, backgroundColor);
        }
        stopFrame();
    }
}
