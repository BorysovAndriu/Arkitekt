package io.arkitekt.testsPages.LinkPage;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class LinkHyperlink extends TestBasePages {

    @Test(priority = 1)
    public void addLink() throws Exception {
        pages.getPagesHelper().addPages( "NEW LINK", 4);
    }

    @Test(priority = 2)
    public void insertContentLinkPage() throws Exception {
        pages.getHyperlinkHelper().insertContentLinkPage(4);
    }

    @Test(priority = 3)
    public void deleteLink() throws Exception {
        pages.getPagesHelper().deletePages(4, "HOME");
    }
}
