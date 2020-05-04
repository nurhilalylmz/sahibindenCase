package Methods;

import Test.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
    protected WebDriver driver = BaseTest.driver;
    protected JavascriptExecutor jse = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    public BaseMethods(WebDriver driver) {
        super();
    }

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

    //İlgili elementin text'ini getirir.
    protected String getText(By by) {
        return findByElement(by).getText();
    }

    protected void clickElement(By by) {
        try {
            findByElement(by).click();
            waitSeconds(1);
            logMessage(getText(by) + " elementine tıklandı.");
        } catch (Exception e) {
            logMessage("Elemente tıklanamadı. Element: " + by + " Hata: " + e.getMessage());
        }

    }

    //Verilen URL'in doğruluğunu kotnrol eder.
    protected void checkURlIsTrue(String expectingUrl) {
        if (driver.getCurrentUrl().contentEquals(expectingUrl)) {
            logMessage("URL bilgisi doğru: " + expectingUrl);
        } else {
            logMessage("Gelen URL bilgisi yanlış gözükmektedir.");
            logMessage("Beklenen: " + expectingUrl);
            logMessage("Gelen : " + driver.getCurrentUrl());
        }
    }

    protected void writeText(By by, CharSequence text) {
        try {
            findByElement(by).sendKeys(text);
            waitSeconds(1);
        } catch (Exception e) {
            logMessage("İlgili elemente yazı yazılırken hata oluştu. Element: " + by + " Hata: " + e.getMessage());
        }
    }

    //Sayfayı Javascript ile scroll eder.
    protected void scrollPageWithJavaScript(By by) {
        WebElement element = findByElement(by);
        //Element görünene kadar sayfayı scroll eder.
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    //Sayfayı scroll eder.
    protected void scrollWebPage() {
        jse.executeScript("scroll(0, 300);");
    }

    protected void waitSeconds(int seconds) {
        try {
            logMessage(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logMessage(e.getMessage());
        }
    }

    //Sayfayı belirli bir element yüklenene kadar bekletir.
    protected void waitForPageLoad(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Anasayfa kontrolü yapar.
    protected void checkHomePageControl(By element , String page_title) {
        if (findByElement(element).getText().contains(page_title)) {
            logMessage("Sahibinden Anasayfa'ya gidildi.");
        } else {
            logMessage("Sahibinden Anasayfa'ya gidilemedi.Title: " + page_title);
        }
    }

    //Listeyi scroll eder.
    protected void innerScrollPage(By scrollBar, int scrollPoints) {
        WebElement webElement = findByElement(scrollBar);
        try {
            waitSeconds(2);
            int numberOfPixelsHoldNumber = 10;
            action.moveToElement(webElement).clickAndHold().moveByOffset(0, numberOfPixelsHoldNumber)
                    .release(webElement).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void clickIfValueFound(By by){
        if(findByElement(by).isEnabled())
            clickElement(by);
    }

}
