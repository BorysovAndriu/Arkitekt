package io.arkitekt.appManager.operationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class PagesBackgroundHelper extends PagesHelperBase{

    public PagesBackgroundHelper(WebDriver driver) {
        super(driver);
    }

    public void ColorEditor(By locator, By field) throws InterruptedException {
        click(locator);
        driver.findElement(field).
                sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        type("#54E135", field);
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void backgroundColor(int x) throws InterruptedException {
        openBackgroundTab(x);
        ColorEditor(By.cssSelector("#page_background_color #colorPreview"),
                By.xpath("//input[@name='page_background_color']"));
        checkBuilderBackground(x, "background-color", "rgba(84, 225, 53, 1)");
        checkSubdomainBackground(x, "background-color", "rgba(84, 225, 53, 1)");
    }

    public void resetToDefaultBackgroundColor(int x) throws InterruptedException {
        openBackgroundTab(x);
        click(By.cssSelector("#page_background_color #colorPreview"));
        click(By.xpath("//button[@id='background_reset_button']"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkBuilderBackgroundReset(x, "background-color", "rgba(0, 0, 0, 0)");
        checkSubdomainBackground(x, "background-color", "rgba(0, 0, 0, 0)");
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void addBackgroundImage(int x) throws InterruptedException {
        openBackgroundTab(x);
        attachImage(By.xpath("//input[@name='background_tmp_image_file']"), "src/test/resources/background.jpg");
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
        checkBuilderBackgroundImage(x);
        checkSubdomainBackgroundImage(x, "background-image");
    }

    public void deleteBackgroundImage(int x) throws InterruptedException {
        openBackgroundTab(x);
        click(By.xpath("//div[@id='background-page-image']//a"));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        checkBuilderBackgroundImageOff(x);
        checkSubdomainBackgroundImageOff(x);
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void addBackgroundImageOverlay(int x) throws InterruptedException {
        openBackgroundTab(x);
        ColorEditor(By.cssSelector("#page_background_image_overlay_color #colorPreview"),
                By.xpath("//input[@name='page_background_image_overlay_color']"));
        checkBuilderImageOverlay(x);
        checkSubdomainImageOverlay(x);
    }

    public void checkBuilderImageOverlay(int x) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x == 33) {
            String color = (driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                    getCssValue("background-image"));
            String c = color.substring(0, 38);
            assertEquals(color, "linear-gradient(rgba(84, 225, 53, 0.3)");
        } else if (x == 22) {
            String color = (driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue("background-image"));
            String c = color.substring(0, 38);
            assertEquals(c, "linear-gradient(rgba(84, 225, 53, 0.3)");
        }
        stopFrame();
    }

    public void checkSubdomainImageOverlay(int x) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x == 1 || x == 33) {
            String color = (driver.findElement(By.xpath("//div[@class='content-wrapper']")).
                    getCssValue("background-image"));
            String c = color.substring(0, 38);
            assertEquals(c, "linear-gradient(rgba(84, 225, 53, 0.3)");
        } else if (x == 22) {
            String color = (driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue("background-image"));
            String c = color.substring(0, 38);
            assertEquals(c, "linear-gradient(rgba(84, 225, 53, 0.3)");
        }
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void chooseImageSetting(int x, String type, String openGroup) throws InterruptedException {
        openBackgroundTab(x);
        click(By.xpath(openGroup));
        click(By.xpath(type));
        click(By.xpath("//*[@href='#!/pages']//following-sibling::div/button"));
        click(By.xpath("//*[@id='page_options']//a[@href='#!/pages']"));
    }

    public void ImageScalingFit(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group background_image_settings']//ul/li[2]",
                "//div[@class='form-group background_image_settings']//input");
        checkBuilderBackground(x, "background-repeat", "no-repeat, no-repeat");
        checkSubdomainBackground(x, "background-repeat", "no-repeat, no-repeat");
    }

    public void ImageScalingPattenr(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group background_image_settings']//ul/li[3]",
                "//div[@class='form-group background_image_settings']//input");
        checkBuilderBackground(x, "background-repeat", "repeat, repeat");
        checkSubdomainBackground(x, "background-repeat", "repeat, repeat");
    }

    public void ImageScalingFill(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group background_image_settings']//ul/li[1]",
                "//div[@class='form-group background_image_settings']//input");
        checkBuilderBackground(x, "background-size", "cover, cover");
        checkSubdomainBackground(x, "background-size", "cover, cover");
    }

    public void ScrollingEffectFix(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group page-scrolling-effect background_image_settings']//ul/li[1]",
                "//div[@class='form-group page-scrolling-effect background_image_settings']//input");
        checkBuilderBackground(x, "background-attachment", "fixed, fixed");
        checkSubdomainBackground(x, "background-attachment", "fixed, fixed");
    }

    public void ScrollingEffectNone(int x) throws InterruptedException {
        chooseImageSetting(x, "//div[@class='form-group page-scrolling-effect background_image_settings']//ul/li[2]",
                "//div[@class='form-group page-scrolling-effect background_image_settings']//input");
        checkBuilderBackground(x, "background-attachment", "scroll, scroll");
        checkSubdomainBackground(x, "background-attachment", "scroll, scroll");
    }

    public void checkBuilderBackground(int x, String valueName, String value) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x == 33) {
            String color = driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                    getCssValue(valueName);
            assertEquals(color, value);
        } else if (x == 22) {
            String cssValue = driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue(valueName);
            assertEquals(cssValue, value);
        }
        stopFrame();
    }

    public void checkBuilderBackgroundReset(int x, String valueName, String value) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x == 33) {
            String color = driver.findElement(By.xpath("//div[@class='content-wrapper']")).
                    getCssValue(valueName);
            assertEquals(color, value);
        } else if (x == 22) {
            String cssValue = driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue(valueName);
            assertEquals(cssValue, "rgba(255, 255, 255, 1)");
        }
        stopFrame();
    }

    public void checkSubdomainBackground(int x, String valueName, String value) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x == 1 || x == 33) {
            String cssValue = driver.findElement(By.xpath("//div[@class='content-wrapper']")).
                    getCssValue(valueName);
            assertEquals(cssValue, value);
        } else if (x == 22) {
            String cssValue = driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue(valueName);
            assertEquals(cssValue, value);
        }
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkBuilderBackgroundImage(int x) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x == 33) {
            Assert.assertTrue((driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                    getCssValue("background-image")).length() > 5, "none");
        } else if (x == 22) {
            Assert.assertTrue((driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue("background-image")).length() > 5, "none");
        }
        stopFrame();
    }

    public void checkSubdomainBackgroundImage(int x, String propertyName) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x == 1 || x == 33) {
            Assert.assertTrue((driver.findElement(By.xpath("//div[@class='content-wrapper']")).
                    getCssValue("background-image")).length() > 5, "none");
        } else if (x == 22) {
            Assert.assertTrue((driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue(propertyName)).length() > 5, "none");
        }
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }

    public void checkBuilderBackgroundImageOff(int x) throws InterruptedException {
        gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
        if (x == 1 || x == 33) {
            Assert.assertFalse((driver.findElement(By.xpath("//div[@class='content-wrapper important_color']")).
                    getCssValue("background-image")).length() > 5, "none");
        } else if (x == 22) {
            Assert.assertFalse((driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue("background-image")).length() > 5, "none");
        }
        stopFrame();
    }

    public void checkSubdomainBackgroundImageOff(int x) throws InterruptedException {
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
        gotoFrame(By.cssSelector("#page_preview_iframe"));
        if (x == 1 || x == 33) {
            Assert.assertFalse(driver.findElement(By.xpath("//div[@class='content-wrapper']")).
                    getCssValue("background-image").length() > 5, "none");
        } else if (x == 22) {
            Assert.assertFalse((driver.findElement(By.xpath("//div[@class='content-wrapper']/section[1]")).
                    getCssValue("background-image")).length() > 5, "none");
        }
        stopFrame();
        hover(By.cssSelector(".hover_preview_button"), By.cssSelector("#toggle_preview"));
    }
}
