package io.arkitekt.testsWidgets.Blog;

import io.arkitekt.testsWidgets.TestBaseWidgets;
import org.testng.annotations.Test;

public class Blog extends TestBaseWidgets {

    /*@Test(priority = 1)
    public void addPage() throws Exception {

    }
*/
    //set at home test +

    @Test(priority = 3)
    public void addBlog() throws Exception {
        widgets.getWidgetsHelper().addWidget("blog");
    }

    @Test(priority = 4)
    public void addPost() throws InterruptedException {
        widgets.getWidgetsHelper().addPost("blog", "add");
    }

    @Test(priority = 5)
    public void addCategoryPost() throws InterruptedException {
        widgets.getWidgetsHelper().addMetaPost("categories");
    }

    @Test(priority = 6)
    public void addCategoryBlog() throws InterruptedException {
        widgets.getWidgetsHelper().addCategoryBlog("blog", "edit");
    }

    @Test(priority = 7)
    public void addTagPost() throws InterruptedException {
        widgets.getWidgetsHelper().addMetaPost("tags");
    }

    @Test(priority = 8)
    public void addAuthorPost() throws InterruptedException {
        widgets.getWidgetsHelper().addMetaPost("authors");
    }

    @Test(priority = 9)
    public void addThumbnailPost() throws InterruptedException {
        widgets.getWidgetsHelper().addThumbnailPost();
    }

    @Test(priority = 10)
    public void addExcerpt() throws InterruptedException {
        widgets.getWidgetsHelper().addExcerpt();
    }

    @Test(priority = 11)
    public void showDate() throws InterruptedException {
        widgets.getWidgetsHelper().addDate();
    }

    @Test(priority = 12)
    public void showLikes() throws InterruptedException {
        widgets.getWidgetsHelper().addLikes();
    }

    @Test(priority = 13)
    public void showShare() throws InterruptedException {
        widgets.getWidgetsHelper().addShare();
    }

    @Test(priority = 14)
    public void showReadeMore() throws InterruptedException {
        widgets.getWidgetsHelper().addReadMoreButton();
    }

    /** Неможу вибрати лейаут з дропдауну
    @Test(priority = 15)
    public void setLayoutCards() throws InterruptedException {
        widgets.getWidgetsHelper().setLayout("blog", "edit", "cards");
    }

    @Test(priority = 16)
    public void setLayoutMasonry() throws InterruptedException {
        widgets.getWidgetsHelper().setLayout("blog", "edit", "masonry");
    }

    @Test(priority = 17)
    public void setLayoutListing() throws InterruptedException {
        widgets.getWidgetsHelper().setLayout("blog", "edit", "listing");
    }
*/

    /**
    @Test(priority = 8)
    public void addTagPost() throws InterruptedException {
        widgets.getWidgetsHelper().deleteTagPost();
    }

    @Test(priority = 8)
    public void addAuthorPost() throws InterruptedException {
        widgets.getWidgetsHelper().deleteAuthorPost();
    }

     @Test(priority = 9)
     public void deleteExcerptPost() throws InterruptedException {
     widgets.getWidgetsHelper().deleteExcerptPost();
     }

    @Test(priority = 10)
    public void deleteThumbnailPost() throws InterruptedException {
        widgets.getWidgetsHelper().deleteThumbnailPost();
    }
*/

    @Test(priority = 10)
    public void deletePost() throws InterruptedException {
        widgets.getWidgetsHelper().deletePost();
    }

    @Test(priority = 11)
    public void deleteBlog() throws Exception {
        widgets.getWidgetsHelper().deleteWidgetTAB("blog", "remove");
    }

}
