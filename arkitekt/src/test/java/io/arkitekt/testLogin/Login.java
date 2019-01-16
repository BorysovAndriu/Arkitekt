package io.arkitekt.testLogin;

import io.arkitekt.appManager.MailMessage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class Login extends TestBaseLogin {

    @Test(priority = 1)
    public void testLogin() throws InterruptedException, IOException {
        app1.getNavHelperLeftPanel().login("1111111111");
        app1.getNavHelperLeftPanel().writeCookies();
        app1.getNavHelperLeftPanel().initListSite(true);
    }

/* в розробці
    @Test (priority = 2)
    public void recoverPassword() throws InterruptedException, IOException, MessagingException {
        app1.getNavHelperLeftPanel().click(By.xpath("//a[@class='btn btn-link']"));
        app1.getNavHelperLeftPanel().openPasswordRecovery();

        List<MailMessage> mailMessages = app1.mail().waitForMail(1,10000);
        String link = findButtonRecover(mailMessages, "user1@localhost.localdomain");
        app1.getNavHelperLeftPanel().finish(link,"2222222222");

    }

    private String findButtonRecover(List<MailMessage> mailMessages, String s) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(s)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }
   */
}
