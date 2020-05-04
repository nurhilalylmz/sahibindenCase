package Page;

import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Integer.parseInt;

public class MainPage extends BaseMethods {
    ContantsMainPage mainPage=new ContantsMainPage();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage closePopup(){
        waitForPageLoad(mainPage.copyrightText);
        waitElementToClickable(mainPage.splashMainPage);
        clickElement(mainPage.splashMainPage);
        return new MainPage(driver);
    }

    public MainPage gotoHomepage(){
        clickElement(mainPage.buttongotoHomepage);
        waitForPageLoad(mainPage.copyrightText);
        return new MainPage(driver);
    }
    public MainPage checkHomepage(String page_title){
        checkHomePageControl(mainPage.textCauseHomePage,page_title);
        Assert.assertTrue("Pop-up kapatılamadığından anasayfa açılamadı.",getText(mainPage.textCauseHomePage).contains("Anasayfa Vitrini"));
        return new MainPage(driver);
    }
    public MainPage goToVasitaPage(){
        clickElement(mainPage.buttongotoCarPage);
        waitForPageLoad(mainPage.copyrightText);
        logMessage(getText(mainPage.vasitaPageControl));
        Assert.assertTrue("Vasıta Kategorisi tıklanıp açılamadı.",
                getText(mainPage.vasitaPageControl).contains("Vasıta Vitrin"));
        return new MainPage(driver);

    }
    public MainPage goToRentCarPage(){
        clickElement(mainPage.buttongotoRentCarPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Kiralık Araçlar Kategorisi tıklanıp açılamadı.",getText(mainPage.rentPageControl).contains("Kiralık Araçlar Vitrin"));
        return new MainPage(driver);
    }
    public MainPage gotoCarPage(){
        clickElement(mainPage.buttonOtomobilPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Otomobil Kategorisine tıklanıp açılamadı."
                ,getText(mainPage.carPageControl).contains("Otomobil"));
        return new MainPage(driver);
    }
    public MainPage controlURL(){
        checkURlIsTrue(findByElement(mainPage.buttonOtomobilPage).getAttribute("href"));
        waitForPageLoad(mainPage.copyrightText);
        return new MainPage(driver);
    }
    public MainPage goToSpesificCarBrand(){
        scrollWebPage();
        innerScrollPage(mainPage.scrollBarInnerList,400);
        clickIfValueFound(mainPage.buttonSpesificCarOpel);
        waitForPageLoad(mainPage.copyrightText);

        Assert.assertTrue("Opel Kategorisine tıklanıp açılamadı."
                ,getText(mainPage.textSpesificCarOpel).contains("Opel"));
        return new MainPage(driver);
    }

}
