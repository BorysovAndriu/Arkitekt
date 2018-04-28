package io.arkitekt;

import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
  public void testCreateSite() throws Exception {
    login("andriu.test.post.1@gmail.com","1111111111" );
    initListSite();
    createSite();
  }

}

