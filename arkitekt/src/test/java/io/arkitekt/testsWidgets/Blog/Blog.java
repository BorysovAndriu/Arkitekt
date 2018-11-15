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
    public void addPost() throws InterruptedException {
        widgets.getWidgetsHelper().addPost("blog", "add");
    }

    @Test(priority = 4)
    public void addCategoryPost() throws InterruptedException {
        widgets.getBlogHelper().addMetaPost("categories");
    }

    @Test(priority = 5)
    public void addCategoryBlog() throws InterruptedException {
        widgets.getBlogHelper().addCategoryBlog("blog", "edit");
    }

    @Test(priority = 6)
    public void addTagPost() throws InterruptedException {
        widgets.getBlogHelper().addMetaPost("tags");
    }

    @Test(priority = 7)
    public void addAuthorPost() throws InterruptedException {
        widgets.getBlogHelper().addMetaPost("authors");
    }

    @Test(priority = 8)
    public void addThumbnailPost() throws InterruptedException {
        widgets.getBlogHelper().addThumbnailPost();
    }

    @Test(priority = 9)
    public void addExcerpt() throws InterruptedException {
        widgets.getBlogHelper().addExcerpt();
    }

    @Test(priority = 10)
    public void showDate() throws InterruptedException {
        widgets.getBlogHelper().addDate();
    }

    @Test(priority = 11)
    public void showLikes() throws InterruptedException {
        widgets.getBlogHelper().addLikes();
    }

    @Test(priority = 12)
    public void showShare() throws InterruptedException {
        widgets.getBlogHelper().addShare();
    }

    @Test(priority = 13)
    public void showReadeMore() throws InterruptedException {
        widgets.getBlogHelper().addReadMoreButton();
    }

    @Test(priority = 14)
    public void openPost() throws InterruptedException {
        widgets.getBlogHelper().openPost();
    }

    @Test(priority = 15)
    public void setLayoutCards() throws InterruptedException {
        widgets.getBlogHelper().setLayout("blog", "edit", "cards");
    }

    @Test(priority = 16)
    public void setLayoutMasonry() throws InterruptedException {
        widgets.getBlogHelper().setLayout("blog", "edit", "masonry");
    }

    @Test(priority = 17)
    public void setLayoutListing() throws InterruptedException {
        widgets.getBlogHelper().setLayout("blog", "edit", "listing");
    }

    @Test(priority = 18)
    public void deleteTagPost() throws InterruptedException {
        widgets.getBlogHelper().deleteMetaPost("tags");
    }

    @Test(priority = 19)
    public void deleteAuthorPost() throws InterruptedException {
        widgets.getBlogHelper().deleteMetaPost("authors");
    }

<<<<<<< HEAD
    /*

        @Test(priority = 9)
        public void deleteExcerptPost() throws InterruptedException {
            widgets.getWidgetsHelper().deleteExcerptPost();
        }

        @Test(priority = 10)
        public void deleteThumbnailPost() throws InterruptedException {
            widgets.getWidgetsHelper().deleteThumbnailPost();
        }
    */

    @Test(priority = 28)
    public void addScheduledPost() throws InterruptedException {
        widgets.getWidgetsHelper().addScheduled();
    }

    @Test(priority = 29)
    public void addDraftPost() throws InterruptedException {
        widgets.getWidgetsHelper().addDraft();
=======
    @Test(priority = 20)
    public void deleteExcerptPost() throws InterruptedException {
        widgets.getBlogHelper().deleteExcerptPost();
    }

    @Test(priority =21)
    public void deleteThumbnailPost() throws InterruptedException {
        widgets.getBlogHelper().deleteThumbnailPost();
>>>>>>> master
    }

    @Test(priority = 22)
    public void deletePost() throws InterruptedException {
        widgets.getWidgetsHelper().deletePost();
    }

    @Test(priority = 23)
    public void deleteBlog() throws Exception {
        widgets.getWidgetsHelper().deleteWidgetTAB("blog", "remove");
    }

    @Test(priority = 24)
    public void deletePage() throws Exception {
        widgets.getPagesHelper().deletePages(1, "HOME");
    }
}
