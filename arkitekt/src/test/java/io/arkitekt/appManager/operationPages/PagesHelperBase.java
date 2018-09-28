package io.arkitekt.appManager.operationPages;

import io.arkitekt.appManager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PagesHelperBase extends HelperBase {

    public PagesHelperBase(WebDriver driver) {
        super(driver);
    }

    public By findPagesCards(int x) {
        By locator = By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]/div[1]");
        String idFirstPage = getIdPage("id", locator);
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
            By page = By.xpath(String.format("//div[@id='%s']/div[1]", idFirstPage));
            return page;
        } else if (x == 3) {
            checking("folder", locator, "data-type");
            By dropdown = By.xpath(String.format("//div[@id='%s']/div[1]", idFirstPage));
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
            By link = By.xpath(String.format("//div[@id='%s']/div[1]", idFirstPage));
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
                moveToElement(driver.findElement(findPagesCards(x))).click().build().perform();
        if (x == 2 || x == 33 || x == 1) {
            findxPathDeleteIcon(x);
            click(By.xpath("//*[@id=\"menu_item_remove\"]"));
            click(By.xpath("//button[@id='delete_page']"));
            if (x == 33) {
                assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Empty DropDown')]")).isDisplayed());
            } else {
                builderCheck(x, namePage);
                subdomainCheck(x, namePage);
            }
        } else if (x == 22 || x == 3 || x == 4) {
            findxPathDeleteIcon(x);
            click(By.xpath("//button[id='delete_page']"));
            if (x == 22) {
                assertFalse(driver.findElement(By.xpath("//p[@class='sb5-empty-text']")).isDisplayed());
            } else {
                builderCheck(x, namePage);
                subdomainCheck(x, namePage);
            }
        }
    }

    private void findxPathDeleteIcon(int x) throws InterruptedException {
        By xPathContainerPage = By.xpath((findPagesCards(x) + "//span[@class='menu-item-option a-builder-icon-dots-vertical menu-item-options']").substring(9).trim());
        By xPathSimplePage = By.xpath((findPagesCards(x) + "//span[@class='menu-item-delete menu-item-options a-builder-icon-delete']").substring(9).trim());

        if(x==1 || x==2 || x==33) {
            click(xPathContainerPage);
        } else {
            click(xPathSimplePage);
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
        if (isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
        checking(nameUrl, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"), "pathname");
        } else checking(nameUrl, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"), "pathname");
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

    public void openBannerTab(int x) throws InterruptedException {
        openSettingPages(x);
        click(By.xpath("//a[@href='#page_banner']"));
    }
}
