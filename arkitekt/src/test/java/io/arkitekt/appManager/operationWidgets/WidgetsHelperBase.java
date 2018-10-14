package io.arkitekt.appManager.operationWidgets;

import io.arkitekt.appManager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WidgetsHelperBase extends HelperBase {

    public WidgetsHelperBase(WebDriver driver) {
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
        isElementPresent(By.cssSelector(".sb-5-empty-ingorm"));
        stopFrame();
    }

    public void addCategoryBlog(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        click(By.xpath(String.format("//div[@id='edit_%s_block']//i[@class='a-builder-icon-plus']", nameWidget)));
        moveToBable(By.xpath("//div[@id='blog_categories']//div[@class='tag-keyword in_focus']//input"), "News");
        List<WebElement> selectedBableis = driver.findElements(By.xpath("//div[@class='tag-keyword selected_keyword']"));
        if (selectedBableis.size() > 0) {
            for (int i = 1; i <= selectedBableis.size(); i++) {
                click(By.xpath("(//div[@class='tag-keyword selected_keyword'])[1]"));
            }
            click(By.xpath("(//div[@id='blog_categories']//div[@class='tag-keyword in_focus'])[last()]"));
        } else {
            click(By.xpath("(//div[@id='blog_categories']//div[@class='tag-keyword in_focus'])[last()]"));
        }
        saveChange(nameWidget);
        checkingWidgetGagBuilder();
        checkingWidgetGagSubdomain();
    }

    public void addPost(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        type("TestPost", By.name("blog_post_title"));
        String idPost = getIdPage("data-activates", By.xpath("//input[@value='Draft']"));
        click(By.xpath("//input[@value='Draft']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[2]", idPost)));
        openSettingTAB();
        click(By.xpath("//button[@data-keywords='categories']"));
        click(By.xpath("(//div[@id='post_categories_list']//div[@class='tag-keyword'])[last()]"));
        click(By.xpath("//div[@id='post_keywords_modal']//button[text()='Save']"));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigPostBuilder();
        checkigPostSubdomain();
    }

    public void deletePost() throws InterruptedException {
        movePostTAB();
        click(By.xpath("//button[@id='delete_post_trigger' and text()='Remove']"));
    }

    public void addThumbnailPost() throws InterruptedException {
        movePostTAB();
        openSettingTAB();
        attachImage(By.xpath("//div[@id='edit_post_block']//input[@name='block[image]']"),
                "src/test/resources/ThumbnailPost.jpg");
    }

    public void moveToBable(By bable, String text) {
        new Actions(driver).moveToElement(driver.findElement(bable)).sendKeys(text).build().perform();
    }

    public void openSettingTAB() throws InterruptedException {
        click(By.xpath("//a[@href='#post_settings']"));
    }

    public void saveChange(String nameWidget) throws InterruptedException {
        click(By.xpath(String.format("//div[@id='edit_%s_block']//button[text()='Save']", nameWidget)));
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

    public void movePostTAB() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        hover(By.xpath("//div[@class='blog-block row']/div[1])"),
                By.xpath("//div[@class='blog-block row']/div[1]//span[@class='sb5-remove-el-post']"));
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

    public void checkingWidgetGagBuilder() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        isElementPresent(By.xpath("//img[@class='img-responsive gag']"));
        stopFrame();
    }

    public void checkingWidgetGagSubdomain() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        isElementPresent(By.xpath("//img[@class='img-responsive gag']"));
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkigPostBuilder() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        checking("News", By.xpath("//div[@class='blog-block row']/div[1]"), "data-block-categories");
        stopFrame();
    }

    public void checkigPostSubdomain() throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        checking("News", By.xpath("//div[@class='blog-block']/div[1]"), "data-block-categories");
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

}
