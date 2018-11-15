package io.arkitekt.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class HelperBase {
    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String password) throws InterruptedException, IOException {
        click(By.xpath("//a[@class='btn btn-link']"));
        type(readeEmail(), By.id("user_email"));
        type(password, By.id("user_password"));
        click(By.name("commit"));
    }

    public void openSite(String url) {
        driver.navigate().to(url);
    }

    public void clickNavigation() throws InterruptedException {
        /*
        if(isElementPresent(By.xpath("//button[@type='button']"))) {
            click(By.xpath("//button[@type='button']"));
        }
        */

        By locatorLink = By.xpath("(//nav[starts-with(@class, 'active_navbar')]//ul)[1]/li");
        List<WebElement> links = driver.findElements(locatorLink);
        for (int i = 0; i < links.size(); i++) {
            WebElement link = driver.findElement(By.xpath("(//nav[starts-with(@class, 'active_navbar')]//ul)[1]/li[" + (i + 1) + "]"));
            link.click();

        }
    }

    public int getCountSite() {
        List<WebElement> listsite = driver.findElements(By.xpath("//div[@id='sites_list']//li[@data-created_at]"));
        return listsite.size();
    }

    public void openFirstSite() throws InterruptedException {
        click(By.xpath("//div[@id='sites_list']//li[2]"));
    }

    public void type(String text, By locator) throws InterruptedException {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void typeN(String text, By locator) throws InterruptedException {
        click(locator);
        Thread.sleep(1000);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text); //Keys.ENTER, Keys.ENTER,
    }

    public void clickA(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void click(By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Thread.sleep(5000);
        driver.findElement(locator).click();
    }

    public String gotoTab() throws InterruptedException {
        String firstTab = driver.getWindowHandle();
        clickA(By.xpath("//a[@class='simple-btn ripple-btn']"));
        Thread.sleep(5000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        return firstTab;
    }

    public void gotoFrame(By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().frame(driver.findElement(locator));
        Thread.sleep(10000);
    }

    public void stopFrame() throws InterruptedException {
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    public void closeTab() throws InterruptedException {
        ArrayList<String> firstTab = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(firstTab.get(0));
    }

    public void checking(String text, By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String existingText = driver.findElement(locator).getAttribute(value);
        Assert.assertEquals(text, existingText);
    }

    public void checkingText(String text, By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String existingText = driver.findElement(locator).getText();
        assertEquals(text, existingText);
    }

    public boolean isElementFound(String text, By locator, String value) {
        try {
            checking(text, locator, value);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isElementDesplayed(By locator) {
        try {
            driver.findElement(locator).click();
            return true;
        } catch (ElementNotVisibleException ex) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getId(String text, By locator) {
        String id = driver.findElement(locator).getAttribute(text);
        id = id.replaceAll("[^0-9]", "");
        return id;
    }

    public String getIdPage(String text, By locator) {
        String id = driver.findElement(locator).getAttribute(text);
        return id;
    }

    public void hover(By locatorFind, By locatorClick) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorFind));
        new Actions(driver).
                moveToElement(driver.findElement(locatorFind)).build().perform();
        Thread.sleep(1000);
        click(locatorClick);
    }

    public void slider(By container, By slider, int x, int y) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (container));
        new Actions(driver).
                moveToElement(driver.findElement(container)).
                clickAndHold(driver.findElement(slider)).moveByOffset(x, y).release().build().perform();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void attachImage(By locator, String namepath) {
        File file = new File(namepath);
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void doubleClick(By locator) {
        new Actions(driver).doubleClick(driver.findElement(locator)).build().perform();
        //driver.findElement(locator).sendKeys(Keys.CONTROL+"a");
    }

    public void initListSite(boolean collapse) throws InterruptedException {
        if (collapse == true) {
            while (isElementPresent(By.cssSelector("#choose_template[aria-expanded=\"false\"]"))) {
                click(By.cssSelector("#choose_template"));
            }
        } else {
            while (isElementPresent(By.cssSelector("#choose_template[aria-expanded=\"true\"]"))) {
                click(By.cssSelector("#choose_template"));
            }
        }
    }

    public void writeEmail() throws IOException {
        RegistrData lastEmail = new RegistrData();
        File file = new File("src/test/resources/email.csv");
        PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
        writer.print(lastEmail.getEmail());
        writer.close();
    }

    public String readeEmail() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/email.csv")));
        String email = reader.readLine();
        return email;
    }

    public void writeCookies() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, 10);
        String expired = format.format(calendar.getTime());
        File file = new File("src/test/resources/cookies.csv");
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(writer);

            Cookie ck = driver.manage().getCookieNamed("_my_indicloud_session");
            bf.write((ck.getName()));
            bf.newLine();
            bf.write((ck.getValue()));
            bf.newLine();
            bf.write((ck.getDomain()));
            bf.newLine();
            bf.write((ck.getPath()));
            bf.newLine();
            bf.write((expired));
            bf.newLine();
            bf.flush();
            bf.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cookie readeCookies() throws IOException {
        List<String> lines1 = Files.readAllLines(new File("src/test/resources/cookies.csv").toPath());
        String name = lines1.get(0);
        String value = lines1.get(1);
        String domain = lines1.get(2);
        String path = lines1.get(3);
        Date date = new Date(lines1.get(4));

        Cookie build = new Cookie.Builder(name, value).
                domain(domain).
                path(path).
                isHttpOnly(true).
                expiresOn(date).build();

        return build;
    }
}

