package io.arkitekt.appManager.operationWidgets;

import io.arkitekt.appManager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WidgetsHelperBase extends HelperBase {

    public WidgetsHelperBase(WebDriver driver) {
        super(driver);
    }

    public void addWidget() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        click(By.xpath("//button[@data-tooltip='add Widget']"));
        dragWidget(By.xpath("//div[@data-block='blog']"),By.cssSelector(".sb5-empty-text"));
        stopFrame();
    }

    public void dragWidget(By widget, By place){
        new Actions(driver).
                moveToElement(driver.findElement(widget)).clickAndHold().
                moveToElement(driver.findElement(place)).
                release().build().perform();
    }

}
