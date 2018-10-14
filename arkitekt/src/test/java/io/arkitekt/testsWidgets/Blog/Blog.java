package io.arkitekt.testsWidgets.Blog;

import io.arkitekt.testsWidgets.TestBaseWidgets;
import org.testng.annotations.Test;

public class Blog extends TestBaseWidgets {

    @Test(priority = 1)
    public void addPage() throws Exception {
        widgets.getPagesHelper().addPages("NEW PAGE", 1);
    }

    @Test(priority = 2)
    public void addBlog() throws Exception {
        widgets.getWidgetsHelper().addWidget("blog");
    }

    @Test(priority = 3)
    public void addCategoryBlog() throws InterruptedException {
        widgets.getWidgetsHelper().addCategoryBlog("blog", "edit");
    }

    @Test(priority = 4)
    public void addPost() throws InterruptedException {
        widgets.getWidgetsHelper().addPost("blog", "add");
    }

/**
    @Test(priority = 5)
    public void addThumbnailPost() throws InterruptedException {
        widgets.getWidgetsHelper().addThumbnailPost();
    }

    @Test(priority = 6)
    public void addExcerpt() throws InterruptedException {
        widgets.getWidgetsHelper().addExcerpt();
    }

    @Test(priority = 7)
    public void addTagPost() throws InterruptedException {
        widgets.getWidgetsHelper().addTaglPost();
    }

    @Test(priority = 8)
    public void addAuthorPost() throws InterruptedException {
        widgets.getWidgetsHelper().addAuthorPost();
    }

    @Test(priority = 7)
    public void repost() throws InterruptedException {
        widgets.getWidgetsHelper().repostToSocial();
    }

    @Test(priority = 7)
    public void addTagPost() throws InterruptedException {
        widgets.getWidgetsHelper().deleteTagPost();
    }

    @Test(priority = 8)
    public void addAuthorPost() throws InterruptedException {
        widgets.getWidgetsHelper().deleteAuthorPost();
    }

    @Test(priority = 9)
    public void DeleteThumbnailPost() throws InterruptedException {
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
