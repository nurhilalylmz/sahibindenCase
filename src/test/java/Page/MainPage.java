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
        Assert.assertEquals(mainPage.textCauseHomePage.getText(),controlURlText,
                "Anasayfada olmadığı görüldü.");
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
       // checkURlIsTrue(mainPage.buttonOtomobilPage.getAttribute(searchValue));
        Assert.assertEquals(driver.getCurrentUrl(),mainPage.buttonOtomobilPage.getAttribute(searchValue)
        ,"İstenen sayafada değilsiniz.");
        waitForPageLoad(mainPage.copyrightText);
        return new MainPage(driver);
    }
    public MainPage goToSpesificCarBrand(int numberOfPixelsHoldNumber,String containsPageText){
        scrollWebPage();
        innerScrollPage(mainPage.scrollBarInnerList,numberOfPixelsHoldNumber);
        clickIfValueFound(mainPage.buttonSpesificCarOpel);
        waitSeconds(2);
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertEquals(mainPage.textSpesificCarOpel.getText(),(containsPageText)
                        , "Opel Kategorisine tıklanıp açılamadı.");
        return new MainPage(driver);
    }

}
