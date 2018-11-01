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
        isElementPresent(By.cssSelector(".sb-5-empty-ingorm"));//шукати ров блок якщо є віджет якшо немає то він зникає
        stopFrame();
    }

    public void showMetaBlog(String meta) throws InterruptedException {
        moveWidgetTAB("blog", "edit");
        stopFrame();
        click(By.xpath("//a[@href='#blog_design']"));
        String locator = null;
        if (meta == "tags") {
            locator = "tag";
        } else if (meta == "categories") {
            locator = "category";
        } else if (meta == "authors") {
            locator ="author";
        }

        if(meta == "tags") {
            click(By.xpath(String.format("//input[@name='blog_%s']/following-sibling::span/span", meta)));
            saveChange("blog");
            checkigPostBuilder("#" + meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
            checkigPostSubdomain("#" + meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
        } else {
            click(By.xpath(String.format("//input[@name='blog_%s']/following-sibling::span/span", locator)));
            saveChange("blog");
            checkigPostBuilder(meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
            checkigPostSubdomain(meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
        }
    }

    public void addCategoryBlog(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        click(By.xpath("//a[@href='#blog_categories']"));
        By locator = By.xpath("//div[@id='blog_categories']//div[starts-with (@id,'blog_categories')]");
        List<WebElement> categories = driver.findElements(locator);
        if(categories.size() > 0) {
            for (int i = 1; i <= categories.size(); i++) {
                hover(By.xpath(String.format(locator +"[" + i + "]").substring(9).trim()),
                        By.xpath(String.format(locator +"[" + i + "]/a").substring(9).trim()));
            }
        }
        click(By.xpath(String.
                format("//div[@id='edit_%s_block']//div[@class='pull-right btn btn-breze btn-fab']",
                        nameWidget)));
        moveToBable(By.xpath("//div[@id='blog_categories']//div[@class='tag-keyword in_focus']//input"), "categories");
        click(By.xpath("//div[@id='blog_categories']//div[@class='tag-keyword in_focus']//input"));
        saveChange(nameWidget);
        click(By.xpath("//a[@href='#!/blog']"));
        hover(By.xpath("//div[@class='posts_block']/div[1]"), By.xpath("//div[@class='posts_block']/div[1]//button"));
        click(By.xpath("//button[@data-todo='edit']"));
        openSettingTAB();
        click(By.xpath("//button[@data-keywords='categories']"));
        click(By.xpath("//div[@id='post_categories_list']/div"));
        click(By.xpath("//button[@class='btn btn-default btn-flat keywords-save']"));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigPostBuilder("categories", By.xpath("//span[@class='post-content-category']"), "textContent");
        checkigPostSubdomain("categories", By.xpath("//span[@class='post-content-category']"), "textContent");
        click(By.xpath("//div[@id='site_blog']//a"));
    }

    public void addPost(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        type("TestPost", By.name("blog_post_title"));
        String idPost = getIdPage("data-activates", By.xpath("//input[@value='Draft']"));
        click(By.xpath("//input[@value='Draft']"));
        click(By.xpath(String.format("//ul[@id='%s']/li[2]", idPost)));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigPostBuilder("\n TestPost \n",
                By.xpath("//div[@class='blog-block row']//div[1]//div[starts-with(@class,'sb5-blog-post-title')]/a"), "textContent");
        checkigPostSubdomain("\n TestPost \n", By.xpath("//div[@class='blog-block']/div[1]//a"), "textContent");
    }

    public void deletePost() throws InterruptedException {
        movePostTAB();
        click(By.xpath("//button[@id='delete_post_trigger' and text()='Remove']"));
    }

    public void addThumbnailPost() throws InterruptedException {
        movePostTAB();
        stopFrame();
        openSettingTAB();
        attachImage(By.xpath("//div[@id='edit_post_block']//input[@name='block[image]']"),
                "src/test/resources/ThumbnailPost.jpg");
        click(By.xpath("(//li[@class='post_excerpt_li']//span[@class='check'])[1]"));
        click(By.xpath("(//li[@class='post_excerpt_li']//span[@class='check'])[2]"));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigWidgetBuilder(By.xpath("//div[@class='thumbnail_image thumb_original_banner_selected']"));
        checkigWidgetSubdomain(By.xpath("//div[@class='thumbnail_image banner_selected']"));
    }

    public void addExcerpt() throws InterruptedException {
        movePostTAB();
        stopFrame();
        openSettingTAB();
        gotoFrame(By.id("mce_2_ifr"));
        type("Excerpt", By.xpath("//body[@data-id='mce_2']"));
        stopFrame();
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigPostBuilder("Excerpt", By.xpath("//div[@class='sb5-blog-post-content excerpt-content  ']/p"), "textContent");
        checkigPostSubdomain("Excerpt", By.xpath("//div[@class='sb5-blog-post-content excerpt-content ']/p"), "textContent");
    }

    public void addMetaPost(String mateName) throws InterruptedException {
        movePostTAB();
        stopFrame();
        openSettingTAB();
        click(By.xpath(String.format("//button[@data-keywords='%s']", mateName)));
        By locator = By.xpath(String.format("//div[@id='post_%s_list']/div", mateName));
        List<WebElement> tags = driver.findElements(locator);
        if(tags.size() > 0) {
            for (int i = 1; i <= tags.size(); i++) {
                hover(By.xpath(String.format(locator +"[" + i + "]").substring(9).trim()),
                        By.xpath(String.format(locator +"[" + i + "]/a").substring(9).trim()));
            }
            click(By.xpath("//button[@class='btn btn-default btn-flat keywords-save']"));
            click(By.xpath(String.format("//button[@data-keywords='%s']", mateName)));
        }
        click(By.xpath("//div[@class='modal-body']/div[@class='pull-right btn btn-breze btn-fab']"));
        moveToBable(locator, mateName);
        click(locator);
        click(By.xpath("//button[@class='btn btn-default btn-flat keywords-save']"));
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        showMetaBlog(mateName);
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
        hover(By.xpath("//div[@class='blog-block row']/div[1]"),
                By.xpath("//span[@class='sb5-edit-el-post waves-effect waves-circle']"));
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



}
