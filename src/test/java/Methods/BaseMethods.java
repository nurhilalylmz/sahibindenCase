package Methods;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class BaseMethods {
    protected static WebDriver driver = BaseTest.driver;
    protected JavascriptExecutor jse = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    //Wrapper methodu gözükene kadar bekler.
    protected void waitElementToClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement findByElement(By by) {
        return driver.findElement(by);
    }

    protected void logMessage(String text) {
        System.out.println(text);
    }

    protected String getText(By by) {
        return findByElement(by).getText();
    }

    protected void clickElement(By by) {
        try {
            findByElement(by).click();
            logMessage(getText(by) + " elementine tıklandı.");
        } catch (Exception e) {
            logMessage("Elemente tıklanamadı. Element: " + by + " Hata: " + e.getMessage());
        }

    }

    protected void checkURlIsTrue(String expectingUrl) {
        if (driver.getCurrentUrl().contentEquals(expectingUrl)) {
            logMessage("URL bilgisi doğru: " + expectingUrl);
        } else {
            logMessage("Gelen URL bilgisi yanlış gözükmektedir.");
            logMessage("Beklenen: "+expectingUrl);
            logMessage("Gelen : "+driver.getCurrentUrl());
        }
    }

    protected void writeText(By by, CharSequence text) {
        try {
            findByElement(by).sendKeys(text);
        } catch (Exception e) {
            logMessage("İlgili elemente yazı yazılırken hata oluştu. Element: " + by + " Hata: " + e.getMessage());
        }
    }

    protected void scrollPageWithJavaScript(WebElement element) {
        //Element görünene kadar sayfayı scroll eder.
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void waitSeconds(int seconds) {
        try {
            logMessage(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logMessage(e.getMessage());
        }
    }

    protected void clickAnywhereOnPage() {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.mouseMove(200, 70);
            action.click().build().perform();
            waitSeconds(1);
        } catch (Exception e) {
            logMessage("Pop-up kapatılmaya çalışırken hata alındı. Hata : " + e.getMessage());
        }
    }

    protected void waitForPageLoad(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void writeWithJavascriptExecutor(By by,String text){
        WebElement inputField = findByElement(by);
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputField);
    }
    protected void checkHomePageControl(By element){
            if (findByElement(element).getText().contains("Anasayfa Vitrini")) {
                logMessage("Sahibinden Anasayfa'ya gidildi.");
            } else {
                logMessage("Sahibinden Anasayfa'ya gidilemedi.");
            }
    }
}
