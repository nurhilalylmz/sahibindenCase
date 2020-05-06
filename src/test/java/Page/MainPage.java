package Page;

import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


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
        checkHomePageControl(mainPage.textCauseHomePage,controlURlText);
        Assert.assertTrue("Pop-up kapatılamadığından anasayfa açılamadı.",mainPage.textCauseHomePage.getText().contains("Anasayfa Vitrini"));
        return new MainPage(driver);
    }
    public MainPage goToVasitaPage(String containsPageText){
        clickElement(mainPage.buttongotoCarPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Vasıta Kategorisi tıklanıp açılamadı.",
                mainPage.vasitaPageControl.getText().contains(containsPageText));
        return new MainPage(driver);

    }
    public MainPage goToRentCarPage(String containsPageText){
        clickElement(mainPage.buttongotoRentCarPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Kiralık Araçlar Kategorisi tıklanıp açılamadı.",
                mainPage.rentPageControl.getText().contains(containsPageText));
        return new MainPage(driver);
    }
    public MainPage gotoCarPage(String containsPageText){
        clickElement(mainPage.buttonOtomobilPage);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Otomobil Kategorisine tıklanıp açılamadı."
                ,(mainPage.carPageControl).getText().contains(containsPageText));
        return new MainPage(driver);

    }
    public MainPage controlURL(String searchValue){
        checkURlIsTrue(mainPage.buttonOtomobilPage.getAttribute(searchValue));
        waitForPageLoad(mainPage.copyrightText);
        return new MainPage(driver);
    }
    public MainPage goToSpesificCarBrand(int scrollPoints,int numberOfPixelsHoldNumber,String containsPageText){
        scrollWebPage();
        innerScrollPage(mainPage.scrollBarInnerList,scrollPoints,numberOfPixelsHoldNumber);
        clickIfValueFound(mainPage.buttonSpesificCarOpel);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertTrue("Opel Kategorisine tıklanıp açılamadı."
                ,mainPage.textSpesificCarOpel.getText().contains(containsPageText));
        return new MainPage(driver);
    }

}
