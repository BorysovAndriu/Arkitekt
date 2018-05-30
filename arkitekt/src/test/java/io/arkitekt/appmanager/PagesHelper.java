package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class PagesHelper extends HelperBase{

    public PagesHelper(WebDriver driver) {
        super(driver);
    }

    public void addPages(By locator) {
        clickA(By.xpath("//li//a[@href='#!/pages']"));
        clickA(By.xpath("//button[@id='sb5_add_new_page']"));
        clickA(locator);
    }

    public void addSubPagesC() throws InterruptedException {
        click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]//a"));
        checkingNavPages("This page is empty." + "\n" + "Use the + button to add widgets.",
                By.xpath("//p[@class='sb5-empty-text']"));

    }

    public void addSubPagesD() throws InterruptedException {
        click(By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]/a"));
        checking("New Page", By.xpath("//div[@id=\"site_pages\"]/div[1]//div[2]/div[1]//input"));
        gotoFrame(By.xpath("//div[3]/iframe[2]"));
        checkingNavPages("This page is empty.", By.xpath("//p[starts-with(text(),'This page is empty')]"));
        stopFrame();
    }

    public void checkingNavPages(String text, By locator) throws InterruptedException {
        gotoFrame(By.xpath("//div[3]/iframe[2]"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String existingText = driver.findElement(locator).getText();
        assertEquals(text, existingText);
        stopFrame();
    }


    public void deletePages(By locatorFind, By locator) throws InterruptedException {
        click(By.xpath("//li//a[@href='#!/pages']"));
        String id = getId(locatorFind);
        WebElement xPath =  driver.findElement(By.xpath(String.format("//button[@data-id='%s']", id)));
        new Actions(driver).
                moveToElement(driver.findElement(locatorFind)).click(xPath).build().perform();
        click(locator);
        refresh();
    }


}
