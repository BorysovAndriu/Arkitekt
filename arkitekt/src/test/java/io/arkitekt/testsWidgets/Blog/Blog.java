package io.arkitekt.testsWidgets.Blog;

import io.arkitekt.appManager.operationPages.PagesHelperBase;
import io.arkitekt.testsWidgets.TestBaseWidgets;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Blog extends TestBaseWidgets {

    @Test( priority = 1 )
    public void addPage() throws Exception {
        .addPages( "NEW PAGE", 1);
    }

    @Test(priority = 2)
    public void addBlog() throws Exception{
        widgets.getWidgetsHelper().addWidget();
    }


    @Test(priority = 10)
    public void deletePage() throws Exception {
        pages.getPagesHelper().deletePages(1, "HOME");
    }

}
