package Page;

import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Integer.parseInt;

public class MainPage extends BaseMethods {
    ContantsMainPage mainPage=new ContantsMainPage();

    public void closePopup(){
        waitForPageLoad(mainPage.copyrightText);
        waitElementToClickable(mainPage.splashMainPage);
        clickElement(mainPage.splashMainPage);
    }

    public void gotoHomepage(){
        clickElement(mainPage.buttongotoHomepage);
        waitForPageLoad(mainPage.copyrightText);
    }
    public void checkHomepage(){
        checkHomePageControl(mainPage.textCauseHomePage);
        Assert.assertTrue("Pop-up kapatılamadığından anasayfa açılamadı.",getText(mainPage.textCauseHomePage).contains("Anasayfa Vitrini"));
    }
    public void goToVasitaPage(){
        clickElement(mainPage.buttongotoCarPage);
        waitForPageLoad(mainPage.copyrightText);
        logMessage(getText(mainPage.vasitaPageControl));
        Assert.assertTrue("Vasıta Kategorisi tıklanıp açılamadı.",
                getText(mainPage.vasitaPageControl).contains("Vasıta Vitrin"));

    }
    public void goToRentCarPage(){
        clickElement(mainPage.buttongotoRentCarPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Kiralık Araçlar Kategorisi tıklanıp açılamadı.",getText(mainPage.rentPageControl).contains("Kiralık Araçlar Vitrin"));

    }
    public void gotoCarPage(){
        clickElement(mainPage.buttonOtomobilPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Otomobil Kategorisine tıklanıp açılamadı."
                ,getText(mainPage.carPageControl).contains("Otomobil"));

    }
    public void controlURL(){
        checkURlIsTrue(findByElement(mainPage.buttonOtomobilPage).getAttribute("href"));
        waitForPageLoad(mainPage.copyrightText);
    }
    public void goToSpesificCarBrand(){
        scrollWebPage();
        innerScrollPage(mainPage.scrollBarInnerList,400);
        clickIfValueFound(mainPage.buttonSpesificCarOpel);
        waitForPageLoad(mainPage.copyrightText);

        Assert.assertTrue("Opel Kategorisine tıklanıp açılamadı."
                ,getText(mainPage.textSpesificCarOpel).contains("Opel"));
    }

}
