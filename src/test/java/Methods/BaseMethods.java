package Methods;

import Test.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
    protected  WebDriver driver = BaseTest.driver;
    protected JavascriptExecutor jse = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    public BaseMethods(WebDriver driver) {
        super();
    }

    //Wrapper methodu gözükene kadar bekler.
    protected void waitElementToClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void logMessage(String text) {
        System.out.println(text);
    }

    protected void clickElement(WebElement element) {
        try {
            element.click();
            waitSeconds(1);
            logMessage(element.getText() + " elementine tıklandı.");
        } catch (Exception e) {
            logMessage("Elemente tıklanamadı. Element: " + element + " Hata: " + e.getMessage());
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

    protected void writeText(WebElement element, CharSequence text) {
        try {
            element.sendKeys(text);
            waitSeconds(1);
        } catch (Exception e) {
            logMessage("İlgili elemente yazı yazılırken hata oluştu. Element:"+ element +"Hata: " + e.getMessage());
        }
    }

    //Sayfayı Javascript ile scroll eder.
    protected void scrollPageWithJavaScript(WebElement element) {
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
    protected void waitForPageLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Anasayfa kontrolü yapar.
    protected void checkHomePageControl(WebElement element,String controlText) {
        try {
            if (element.getText().contains(controlText)) {
                logMessage("Anasayfa'ya gidildi.");
            }
        }catch (Exception e)
        {
            logMessage("Gelen değer: "+element.getText());
            logMessage("Anasayfa'ya gidilemedi. Title: "+controlText+", Hata: "+e.getMessage());
        }
    }

    //Listeyi scroll eder.
    protected void innerScrollPage(WebElement scrollBar, int scrollPoints,int numberOfPixelsHoldNumber) {
        try {
            waitSeconds(2);
            action.moveToElement(scrollBar).clickAndHold().moveByOffset(0, numberOfPixelsHoldNumber)
                    .release(scrollBar).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void clickIfValueFound(WebElement element){
        if(element.isEnabled())
            clickElement(element);
    }

}
