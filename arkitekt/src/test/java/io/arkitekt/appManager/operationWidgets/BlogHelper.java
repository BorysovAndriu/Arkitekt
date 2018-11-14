package io.arkitekt.appManager.operationWidgets;

import io.arkitekt.appManager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BlogHelper extends WidgetsHelperBase {
    public BlogHelper(WebDriver driver) {
        super(driver);
    }

    public void showMetaBlog(String meta) throws InterruptedException {
        moveWidgetTAB("blog", "edit");
        stopFrame();
        click(By.xpath("//a[@href='#blog_design']"));
        String locator;
        if (meta == "tags") {
            locator = "tag";
        } else if (meta == "categories") {
            locator = "category";
        } else if (meta == "authors") {
            locator = "author";
        } else {
            locator = meta;
        }

        if (meta == "tags") {
            click(By.xpath(String.format("//input[@name='blog_%s']/following-sibling::span/span", meta)));
            saveChange("blog");
            checkigPostBuilder("#" + meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
            checkigPostSubdomain("#" + meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
        } else {
            click(By.xpath(String.format("//input[@name='blog_%s']/following-sibling::span/span", locator)));
            saveChange("blog");
            if (meta == "date") {
                checkingPresentBuilder(By.xpath("//span[@class='sb5-blog-post-date']"));
                checkingPresentSubdomain(By.xpath("//span[@class='sb5-blog-post-date']"));
            } else if (meta == "likes" || meta == "share") {
                checkingPresentBuilder(By.xpath(String.format("//span[@class='pull-right content_meta_styles sb5-blog-post-%s ']", meta)));
                checkingPresentSubdomain(By.xpath(String.format("//span[@class='pull-right content_meta_styles sb5-blog-post-%s ']", meta)));
            } else if (meta == "read_more") {
                checkingPresentBuilder(By.xpath("//span[@class='read-more_button']"));
                checkingPresentSubdomain(By.xpath("//span[@class='read-more_button']"));
            } else {
                checkigPostBuilder(meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
                checkigPostSubdomain(meta, By.xpath(String.format("//span[@class='post-content-%s']", locator)), "textContent");
            }
        }
    }

    public void addCategoryBlog(String nameWidget, String nameIcon) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        click(By.xpath("//a[@href='#blog_categories']"));
        By locator = By.xpath("//div[@id='blog_categories']//div[starts-with (@id,'blog_categories')]");
        List<WebElement> categories = driver.findElements(locator);
        if (categories.size() > 0) {
            for (int i = 1; i <= categories.size(); i++) {
                hover(By.xpath(String.format(locator + "[" + i + "]").substring(9).trim()),
                        By.xpath(String.format(locator + "[" + i + "]/a").substring(9).trim()));
            }
        }
        click(By.xpath(String.
                format("//div[@id='edit_%s_block']//div[@class='pull-right btn btn-breze btn-fab']",
                        nameWidget)));
        moveToBable(By.xpath("//div[@id='blog_categories']//div[@class='tag-keyword in_focus']//input"), "categories");
        click(By.xpath("//div[@id='blog_categories']//div[@class='tag-keyword in_focus']//input"));
        saveChange(nameWidget);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        click(By.xpath("//div[@class='left-block-item-inner pages active-menu']//a[@href='#!/main-menu']"));
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

    public void addThumbnailPost() throws InterruptedException {
        movePostTAB("edit");
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
        movePostTAB("edit");
        stopFrame();
        openSettingTAB();

        String collapce = driver.findElement(By.id("post_excerpt_checked")).getAttribute("class");
        if (collapce == "collapse") {
            click(By.xpath("(//li[@class='post_excerpt_li']//span[@class='check'])[1]"));
        }

        gotoFrame(By.id("mce_2_ifr"));
        type("Excerpt", By.xpath("//body[@data-id='mce_2']"));
        stopFrame();
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkigPostBuilder("Excerpt",
                By.xpath("//div[@class='sb5-blog-post-content excerpt-content  ']/p"), "textContent");
        checkigPostSubdomain("Excerpt",
                By.xpath("//div[@class='sb5-blog-post-content excerpt-content ']/p"), "textContent");
    }

    public void addMetaPost(String mateName) throws InterruptedException {
        movePostTAB("edit");
        stopFrame();
        openSettingTAB();
        click(By.xpath(String.format("//button[@data-keywords='%s']", mateName)));
        By locator = By.xpath(String.format("//div[@id='post_%s_list']/div", mateName));
        List<WebElement> tags = driver.findElements(locator);
        if (tags.size() > 0) {
            for (int i = 1; i <= tags.size(); i++) {
                hover(By.xpath(String.format(locator + "[" + i + "]").substring(9).trim()),
                        By.xpath(String.format(locator + "[" + i + "]/a").substring(9).trim()));
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

    public void addDate() throws InterruptedException {
        showMetaBlog("date");
    }

    public void addLikes() throws InterruptedException {
        showMetaBlog("likes");
    }

    public void addShare() throws InterruptedException {
        showMetaBlog("share");
    }

    public void addReadMoreButton() throws InterruptedException {
        showMetaBlog("read_more");
    }

    public void setLayout(String nameWidget, String nameIcon, String layout) throws InterruptedException {
        moveWidgetTAB(nameWidget, nameIcon);
        stopFrame();
        click(By.xpath("//a[@href='#blog_design']"));
        click(By.xpath("(//div[@id='blog_design']//input)[1]"));
        String list = getIdPage("data-activates", By.xpath("(//div[@id='blog_design']//input)[1]"));
        if (layout == "cards") {
            click(By.xpath(String.format("//ul[@id='%s']/li[1]/span", list)));
        } else if (layout == "listing") {
            click(By.xpath(String.format("//ul[@id='%s']/li[2]/span", list)));
        } else if (layout == "masonry") {
            click(By.xpath(String.format("//ul[@id='%s']/li[3]/span", list)));
        }
        saveChange(nameWidget);
        checkingPresentBuilder(By.xpath(String.format("//div[@data-layout='%s']", layout)));
        checkingPresentSubdomain(By.xpath(String.format("//div[@data-layout='%s']", layout)));
    }

    public void moveToBable(By bable, String text) {
        new Actions(driver).moveToElement(driver.findElement(bable)).sendKeys(text).build().perform();
    }

    public void openSettingTAB() throws InterruptedException {
        click(By.xpath("//a[@href='#post_settings']"));
    }

    public void openPost() throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        By thumbnail = By.xpath("//div[@class='post-thump-wrap']");
        if (!isElementPresent(thumbnail)) {
            stopFrame();
            addPost("blog", "add");
            addThumbnailPost();
            gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        }
        hover(thumbnail, thumbnail);
        stopFrame();
        checkingPresentBuilder(By.xpath("//div[@id='post_page_banner']"));
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        hover(thumbnail, thumbnail);
        isElementPresent(By.xpath("//div[@id='post_page_banner']"));
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));

        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (isElementPresent(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"))) {
            click(By.xpath("//div[@class='mobile-menu mobilebar_icon active']/button"));
            click(By.xpath("//*[@id='mobilebar']/ul[1]/li[1]/a/span"));
        } else {
            click(By.xpath("//nav[5]/div/div[1]/ul/li[1]/a"));
        }
        stopFrame();
    }

    public void deleteMetaPost(String metaName) throws InterruptedException {
        movePostTAB("edit");
        stopFrame();
        openSettingTAB();
        By locator;
        if (metaName == "authors") {
            locator = By.xpath(String.format("//div[@id='post_%s_keywords']/div", "author"));
        } else {
            locator = By.xpath(String.format("//div[@id='post_%s_keywords']/div", metaName));
        }
        List<WebElement> meta = driver.findElements(locator);
        if (meta.size() > 0) {
            for (int i = 1; i <= meta.size(); i++) {
                hover(By.xpath(String.format(locator + "[" + i + "]").substring(9).trim()),
                        By.xpath(String.format(locator + "[" + i + "]/a").substring(9).trim()));
            }
        }
        click(By.xpath("//div[@id='edit_post_block']//button[text()='Save']"));
        checkingNotPresentBuilder(By.xpath
                (String.format("//div[@class='sb5-blog-post-%s content_meta_styles ']", metaName)));
        checkingNotPresentSubdomain(By.xpath
                (String.format("//div[@class='sb5-blog-post-%s content_meta_styles ']", metaName)));
    }
}

