package io.arkitekt.appManager.operationWidgets;

import io.arkitekt.appManager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainSite extends HelperBase {

    public MainSite(WebDriver driver) {
        super(driver);
    }

    public void addWidget(String nameWidget) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        click(By.xpath("//button[@data-tooltip='Add Widget']"));
        dragWidget(By.xpath(String.format("//div[@data-block='%s']", nameWidget)), By.cssSelector(".sb5-empty-text"));
        stopFrame();
        saveChange(nameWidget);
        checkigWidgetBuilder(By.xpath(String.format("//div[@data-type='%s']", nameWidget)));
        checkigWidgetSubdomain(By.xpath(String.format("//div[@data-type='%s']", nameWidget)));
    }

    public void deleteWidgetTAB(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        click(By.cssSelector("#delete_widget_page"));

        isElementPresent(By.cssSelector(".sb5-empty-ingorm"));//шукати ров блок якщо є віджет якшо немає то він зникає
        stopFrame();
    }

    public void saveChange(String nameWidget) throws InterruptedException {
        click(By.xpath(String.format("//div[@id='edit_%s_block']//button[text()='Save']", nameWidget)));
    }

    public void addPost(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        type("TestPost", By.name("blog_post_title"));
        String idPost = getIdPage("data-activates", By.xpath("//input[@value='Draft']"));
        click(By.xpath("//input[@value='Draft']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[2]", idPost)));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigPostBuilder("\n    "+"TestPost"+"\n  ",
                By.xpath("//div[@class='blog-block row']//div[1]//div[starts-with(@class,'sb5-blog-post-title')]/a"), "textContent");
        checkigPostSubdomain("\n    "+"TestPost"+"\n  ", By.xpath("//div[@class='blog-block']/div[1]//a"), "textContent");
    }

    public void addDraft() throws InterruptedException {
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        click(By.xpath("//div[@class='left-block-item-inner pages active-menu']//a[@href='#!/main-menu']"));
        click(By.xpath("//a[@href='#!/blog']"));
        int before = getCountPost();
        click(By.xpath("//button[@class='pull-right sb5-add-page btn btn-white-plus btn-fab closed waves-effect waves-circle']"));
        isElementPresent(By.xpath("//input[@value='Draft']"));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        int after = getCountPost();
        Assert.assertEquals(after, before + 1);
    }

    public int getCountPost() {
        List<WebElement> listPost = driver.findElements(By.xpath("//div[@class='posts_block']/div"));
        return listPost.size();
    }

    public void addScheduled() throws InterruptedException {
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        click(By.xpath("//div[@class='left-block-item-inner pages active-menu']//a[@href='#!/main-menu']"));
        click(By.cssSelector("#Settings"));
        click(By.xpath("//div[@class='left-block-item-inner settings active-menu']//li[2]/a"));

        By locator =  By.xpath("//select[@name='site_timez']/preceding-sibling::input");
        click(locator);
        String  timeZoneId = getIdPage("data-activates", locator);
        click(By.xpath(String.format("//ul[@id='%s']/li[70]/span", timeZoneId)));

        click(By.xpath("//div[@id='settings_site_general']//button[@class='btn btn-default page-btn-save btn-raised waves-effect']"));
        click(By.xpath("//div[@id='settings_site_general']//a[@href='#!/settings']"));
        click(By.xpath("//div[@class='left-block-item-inner settings active-menu']//a[@href='#!/main-menu']"));
        click(By.xpath("//a[@href='#!/blog']"));
        click(By.xpath("//button[@class='pull-right sb5-add-page btn btn-white-plus btn-fab closed waves-effect waves-circle']"));
        type("TestScheduled", By.name("blog_post_title"));
        String idPost = getIdPage("data-activates", By.xpath("//input[@value='Draft']"));
        click(By.xpath("//input[@value='Draft']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[3]", idPost)));

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MINUTE, 1);
        String scheduledTime = format.format(calendar.getTime());

        attachValue(By.cssSelector("#post_time"), scheduledTime);
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        Thread.sleep(30000);
        refresh();
        String status = getId("data-status", By.xpath("//div[@class='posts_block']/div[1]"));
        Assert.assertEquals(status,"1");
    }

    public void deletePost() throws InterruptedException {
        movePostTAB("remove");
        stopFrame();
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        click(By.cssSelector("#delete_post_trigger"));
        stopFrame();
        checkingPresentBuilder(By.xpath("//div[@class= 'sb5-block-blog-gag a-builder-icon-blog-widget']"));
        checkingPresentSubdomain(By.xpath("//div[@class= 'sb5-block-blog-gag a-builder-icon-blog-widget']"));
    }

    public void dragWidget(By widget, By place) {
        new Actions(driver).
                moveToElement(driver.findElement(widget)).clickAndHold().
                moveToElement(driver.findElement(place)).
                release().build().perform();
    }

    public void moveWidgetTAB(String nameWidget, String nameIcon) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        hover(By.xpath(String.
                        format("//div[@class='sb5-block-handler sb5-block-drag-handle sb5-block-widget-%s ui-draggable-handle']",
                                nameWidget)),
                By.xpath(String.
                        format("//div[@data-type='%s']//span[starts-with(@class,'sb5-%s-el waves-effect waves-circle')]",
                                nameWidget, nameIcon)));
    }

    public void movePostTAB(String iconName) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        By editPostTab = By.xpath("//span[@class='sb5-edit-el-post']");
        By editPostTabafterReload = By.xpath("//span[@class='sb5-edit-el-post waves-effect waves-circle']");
        By removePostTab = By.xpath("//span[@class='sb5-remove-el-post']");
        By removePostTabafterReload = By.xpath("//span[@class='sb5-remove-el-post waves-effect waves-circle']");

        if(iconName == "edit") {
            if (isElementPresent(editPostTabafterReload)) {
                hover(By.xpath("//div[@class='blog-block row']/div[1]"), editPostTabafterReload);
            } else if (isElementPresent(editPostTab)) {
                hover(By.xpath("//div[@class='blog-block row']/div[1]"), editPostTab);
            }
        } else if (iconName == "remove") {
            if (isElementPresent(removePostTabafterReload)) {
                hover(By.xpath("//div[@class='blog-block row']/div[1]"), removePostTabafterReload);
            } else if (isElementPresent(removePostTab)) {
                hover(By.xpath("//div[@class='blog-block row']/div[1]"), removePostTab);
            }
        }
    }

    public void checkigWidgetBuilder(By widget) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        isElementPresent(widget);
        stopFrame();
    }

    public void checkigWidgetSubdomain(By widget) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        isElementPresent(widget);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingPresentBuilder( By locator) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        isElementPresent(locator);
        stopFrame();
    }

    public void checkingPresentSubdomain(By locator) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        isElementPresent(locator);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkigPostBuilder(String text, By locator, String value) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        checking(text, locator, value);
        stopFrame();
    }

    public void checkigPostSubdomain(String text, By locator, String value) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checking(text, locator, value);
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkingNotPresentBuilder(By locator) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (!isElementPresent(locator)) {
            stopFrame();
        }
    }

    public void checkingNotPresentSubdomain(By locator) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if(!isElementPresent(locator)) {
            stopFrame();
            hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        }
    }
}
