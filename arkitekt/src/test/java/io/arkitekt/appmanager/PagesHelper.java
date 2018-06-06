package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class PagesHelper extends HelperBase{

    public PagesHelper(WebDriver driver) {
        super(driver);
    }

    public void addPages(By locator) {
        click(By.xpath("//li//a[@href='#!/pages']"));
        click(By.xpath("//button[@id='sb5_add_new_page']"));
        click(locator);
    }

    public void addSubPages() throws InterruptedException {
        click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
        checkingNavPages("This page is empty." + "\n" + "Use the + button to add widgets.",
                By.xpath("//p[@class='sb5-empty-text']"));
    }

    public void checkingNavPages(String text, By locator) throws InterruptedException {
        gotoFrame(By.xpath("//div[3]/iframe[2]"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String existingText = driver.findElement(locator).getText();
        assertEquals(text, existingText);
        stopFrame();
    }

    public void deletePage(By locatorFind, By locator) throws InterruptedException {
        click(By.xpath("//li//a[@href='#!/pages']"));
        String id= getIdPage(locatorFind);
        hover(locatorFind, By.xpath(String.format("//div[@id='%s']//div[3]/button", id)));
        click(locator);
        //refresh();
    }

    public void deleteContainer (By locatorFind, By locator) throws InterruptedException {
        click(By.xpath("//li//a[@href='#!/pages']"));
        String idContainer = getId(locatorFind);
        String idSubPage = getIdPage (By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)));
        hover(By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)),
                        By.xpath(String.format("//div[@id='%s']//div[4]/button",idSubPage)));
        hover(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]/div[1]"), By.xpath(String.format("//button[@data-id='%s']", idContainer)));
        //refresh();
    }

    public void deleteDropDown(By locatorFind, By locator) throws InterruptedException {
        click(By.xpath("//li//a[@href='#!/pages']"));
        String idContainer = getId(locatorFind);
        String idSubPage = getIdPage (By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)));
        hover(By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idContainer)),
                    By.xpath(String.format("//div[@id='%s']//div[3]/button",idSubPage)));
        click(locator);
        hover(By.xpath("//div[@class='site-top-pages ui-sortable']/div[1]/div[1]"), By.xpath(String.format("//button[@data-id='%s']", idContainer)));
        //refresh();
    }

    public void deleteLink(By locatorFind) throws InterruptedException {
        click(By.xpath("//li//a[@href='#!/pages']"));
        String id= getIdPage(locatorFind);
        hover(locatorFind, By.xpath(String.format("//div[@id='%s']//div[4]/button", id)));
        //refresh();
    }






}
