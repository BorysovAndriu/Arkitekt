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
    public void insertFileLinkPage() throws Exception {
        pages.getHyperlinkHelper().insertFileLinkPage(4);
    }

    @Test(priority = 4)
    public void insertExternalLinkPage() throws Exception {
        pages.getHyperlinkHelper().insertExternalLinkPage(4);
    }

    @Test(priority = 5)
    public void insertNoneLinkPage() throws Exception {
        pages.getHyperlinkHelper().insertNoneLinkPage(4);
    }

    @Test(priority = 6)
    public void deleteLink() throws Exception {
        pages.getPagesHelper().deletePages(4, "HOME");
    }
}
