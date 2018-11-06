package io.arkitekt.testsWidgets.Blog;

import io.arkitekt.testsWidgets.TestBaseWidgets;
import org.testng.annotations.Test;

public class Blog extends TestBaseWidgets {

    /*@Test(priority = 1)
    public void addPage() throws Exception {
        widgets.getPagesHelper().addPages("NEW PAGE", 1);
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
        widgets.getWidgetsHelper().addDate("blog", "edit");
    }

    @Test(priority = 12)
    public void showLikes() throws InterruptedException {
        widgets.getWidgetsHelper().addLikes("blog", "edit");
    }

    @Test(priority = 13)
    public void showShare() throws InterruptedException {
        widgets.getWidgetsHelper().addShare("blog", "edit");
    }

    @Test(priority = 14)
    public void showReadeMore() throws InterruptedException {
        widgets.getWidgetsHelper().addReadMoreButton("blog", "edit");
    }



    /**likes

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

    @Test(priority = 12)
    public void deletePage() throws Exception {
        widgets.getPagesHelper().deletePages(1, "HOME");
    }

}
