package io.arkitekt.appmanager.PagesHelper;

import io.arkitekt.appmanager.HelperBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class PagesHelper extends HelperBase {

    public PagesHelper(WebDriver driver) {
        super(driver);
    }

    public void addPages(By locator, String checkNamePages) throws InterruptedException {
        click(By.xpath("//button[@id='sb5_add_new_page']"));
        click(locator);
        checkingNavPagesBuilder(checkNamePages, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));
        checkNavPagesSubdomain(checkNamePages);
    }

    public void addSubContainer(By addSubPage) throws InterruptedException {
        click(addSubPage);
        checkingNavSubPagesBuilder();
    }

    public void addSubDropDown(By addSubPage, String nameSubDropDown) throws InterruptedException {
        click(addSubPage);
        checkingNavDropDownBuilder(nameSubDropDown);
        checkNavDropDownSubdomain(nameSubDropDown);
    }

    public void deletePages(int x){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(findPagesCards(x)));
        new Actions(driver).
                moveToElement(driver.findElement(findPagesCards(x))).build().perform();
        if (x==2) {
            findxPathDeleteIcon(x);
        }
        else if (x==22){
            findxPathDeleteIcon(x);
        }
        else if (x==3){
            findxPathDeleteIcon(x);
        }
        else if (x==33){
            findxPathDeleteIcon(x);
        }
        else if (x==1){
            findxPathDeleteIcon(x);
        }
        else if (x==4){
            findxPathDeleteIcon(x);
        }
    }

    public void findxPathDeleteIcon(int x) {
        if (x==1 || x==2 || x==4) {
            String deleteIcon = new String (findPagesCards(x) + "//div[4]/button");
            By delete = By.xpath(deleteIcon.substring(8));
            click(delete);
        }
        else if (x==3) {
            String deleteIcon = new String (findPagesCards(x) + "//div[3]/button");
            By delete = By.xpath(deleteIcon.substring(8));
            click(delete);
        }

    }

    public void deletePage(By locatorFind, By locator) throws InterruptedException {
        String id= getIdPage("id", locatorFind);
        hover(locatorFind, By.xpath(String.format("//div[@id='%s']//div[4]/button", id)));
        click(locator);
        checkingNavPagesBuilder("HOME", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        checkNavPagesSubdomain("HOME");
        //refresh();
    }

    public void deleteContainer (int x, By locator) throws InterruptedException {
        //String idContainer = getId(locatorFind);
        //String idSubPage = getIdPage ("id",
                //By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)));
        //hover(By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)),
                        //By.xpath(String.format("//div[@id='%s']//div[4]/button",idSubPage)));
        By iconDelete = By.xpath(findPagesCards(x)+"//div{4}/button");
        hover(findPagesCards(x), iconDelete);
        //hover(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]/div[1]"),
                //By.xpath(String.format("//button[@data-id='%s']", idContainer)));
        click(locator);
        checkingNavPagesBuilder("HOME", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        checkNavPagesSubdomain("HOME");
        //refresh();
    }

    public void deleteDropDown(By locatorFind, By locator) throws InterruptedException {
        String idContainer = getId(locatorFind);
        String idSubPage = getIdPage ("id",
                By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)));
        hover(By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)),
                    By.xpath(String.format("//div[@id='%s']//div[3]/button",idSubPage)));
        click(locator);
        hover(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]/div[1]"),
                By.xpath(String.format("//button[@data-id='%s']", idContainer)));
        checkingNavPagesBuilder("HOME", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        checkNavPagesSubdomain("HOME");
        //refresh();
    }

    public void deleteLink(By locatorFind) throws InterruptedException {
        String id= getIdPage("id", locatorFind);
        hover(locatorFind, By.xpath(String.format("//div[@id='%s']//div[4]/button", id)));
        checkingNavPagesBuilder("HOME", By.xpath("//nav[5]/div/div[1]/ul/li[1]/a/span"));
        checkNavPagesSubdomain("HOME");
        //refresh();
    }

    public void toggleOff(By toggle, String namePage, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        click (toggle);
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if(isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))){
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            String existingText = driver.findElement(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a/span")).getText();
            assertEquals("", existingText);
            //click(By.xpath("//*[@id='mobilebar']/ul[1]/li[2]/a"));
            stopFrame();
        } else {
            String existingText = driver.findElement(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a")).getText();
            assertEquals("", existingText);
            click(By.xpath("//nav[5]/div/div[1]/ul/li[2]/a"));
            stopFrame();
        }
        checkNavPagesSubdomain(namePage);
        click(By.xpath("//a[@class='back-to-menu waves-circle waves-effect' and @href='#!/pages']"));
    }

    public void toggleOn(By toggle, String namePage, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        click (toggle);
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if(isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))){
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            String existingText = driver.findElement(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a/span")).getText();
            assertEquals(namePage, existingText);
            //click(By.xpath("//*[@id='mobilebar']/ul[1]/li[2]/a"));
            stopFrame();
        } else {
            String existingText = driver.findElement(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a")).getText();
            assertEquals(namePage, existingText);
            click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
            stopFrame();
        }
        checkNavPagesSubdomain(namePage);
        click(By.xpath("//a[@class='back-to-menu waves-circle waves-effect' and @href='#!/pages']"));
    }

    public void renamePage(String namePage, By type, String checkText, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        rename(namePage, type);
        checkingNavPagesBuilder(checkText, By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
        checkNavPagesSubdomain(checkText);
    }

    public void renameSubPage(By type, String nameSubDropDown, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        rename(nameSubDropDown, type);
        checkingNavDropDownBuilder(nameSubDropDown);
        checkNavDropDownSubdomain(nameSubDropDown);
    }

    public void renameUrl(String nameUrl, By type, int x) throws InterruptedException {
        openSettingPages(x);
        Thread.sleep(5000);
        rename(nameUrl, type);
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checking(nameUrl, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"),"pathname");
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
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
        checkNavPagesSubdomain(namePage);
    }



    public void openSettingPages(int x) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(findPagesCards(x)));
        click(By.xpath("//*[@id='site_pages']/h5"));
        new Actions(driver).
                moveToElement(driver.findElement(findPagesCards(x))).click().build().perform();
    }

    public void rename(String text, By type) {
        type(text, type);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void checkingNavPagesBuilder(String text, By locator) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if(isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))){
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            String existingText = driver.findElement(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a/span")).getText();
            assertEquals(text, existingText);
            stopFrame();
        } else {
        String existingText = driver.findElement(locator).getText();
        assertEquals(text, existingText);
        stopFrame();
        }
    }

    public void checkingNavSubPagesBuilder() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        String existingText = driver.findElement( By.xpath("//p[@class='sb5-empty-text']")).getText();
        assertEquals("This page is empty." + "\n" + "Use the + button to add widgets.",existingText);
        stopFrame();
    }

    public void checkingNavDropDownBuilder(String text) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if(isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))){
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
            String existingText = driver.findElement(By.xpath("//ul[@style='display: block;']//span")).getText();
            assertEquals(text, existingText);
            stopFrame();
        } else {
            click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
            String existingText = driver.findElement(By.xpath("//nav[5]/div/div[1]/ul/li[1]/ul//a")).getText();
            assertEquals(text, existingText);
            stopFrame();
        }
    }

    public void checkNavDropDownSubdomain(String namePage) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        click(By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));
        checkingText(namePage, By.xpath("//nav[1]/div/div[1]/ul/li[1]/ul//a"));
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkNavPagesSubdomain(String namePage) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (isElementPressent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))){
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            checkingText(namePage, By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a"));
            stopFrame();
            hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));}
        else {
            checkingText(namePage, By.xpath("//nav[1]/div/div[1]/ul/li[1]/a"));
            stopFrame();
        }
    }

    public void checkLockSubdomain() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checkingText("PRIVATE PAGE", By.xpath("//h2[text()='PRIVATE PAGE']"));
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

}
