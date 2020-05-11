package Page;

import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MainPage extends BaseMethods {
    ContantsMainPage mainPage= PageFactory.initElements(driver, ContantsMainPage.class);

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
    public MainPage checkHomepage(String controlURlText){
        Assert.assertEquals(mainPage.textCauseHomePage,controlURlText);
        Assert.assertTrue(mainPage.textCauseHomePage.getText().contains("Anasayfa Vitrini"), "Pop-up kapatılamadığından anasayfa açılamadı.");
        return new MainPage(driver);
    }
    public MainPage goToVasitaPage(String containsPageText){
        clickElement(mainPage.buttongotoCarPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue(mainPage.vasitaPageControl.getText().contains(containsPageText),
                "Vasıta Kategorisi tıklanıp açılamadı.");
        return new MainPage(driver);

    }
    public MainPage goToRentCarPage(String containsPageText){
        clickElement(mainPage.buttongotoRentCarPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue(mainPage.rentPageControl.getText().contains(containsPageText),
                "Kiralık Araçlar Kategorisi tıklanıp açılamadı.");
        return new MainPage(driver);
    }
    public MainPage gotoCarPage(String containsPageText){
        clickElement(mainPage.buttonOtomobilPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue((mainPage.carPageControl).getText().contains(containsPageText)
                        , "Otomobil Kategorisine tıklanıp açılamadı.");
        return new MainPage(driver);

    }
    public MainPage controlURL(String searchValue){
        Assert.assertEquals(driver.getCurrentUrl(),mainPage.buttonOtomobilPage.getAttribute(searchValue));
        waitForPageLoad(mainPage.copyrightText);
        return new MainPage(driver);
    }
    public MainPage goToSpesificCarBrand(int scrollPoints,int numberOfPixelsHoldNumber,String containsPageText){
        scrollWebPage();
        innerScrollPage(mainPage.scrollBarInnerList,numberOfPixelsHoldNumber);
        clickIfValueFound(mainPage.buttonSpesificCarOpel);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue(mainPage.textSpesificCarOpel.getText().contains(containsPageText)
                        , "Opel Kategorisine tıklanıp açılamadı.");
        return new MainPage(driver);
    }

}
