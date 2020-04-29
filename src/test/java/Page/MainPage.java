package Page;

import Contants.ContantsMainPage;
import Methods.BaseMethods;

public class MainPage extends BaseMethods {
    ContantsMainPage mainPage=new ContantsMainPage();
    public void gotoHomepage(){
        clickElement(mainPage.buttongotoHomepage);
        waitForPageLoad(mainPage.copyrightText);
    }
    public void checkHomepage(){
        checkHomePageControl(mainPage.textCauseHomePage);
    }
    public void goToVasitaPage(){
        clickElement(mainPage.buttongotoCarPage);
        waitForPageLoad(mainPage.copyrightText);
    }
    public void goToRentCarPage(){
        clickElement(mainPage.buttongotoRentCarPage);
        waitForPageLoad(mainPage.copyrightText);
    }
    public void gotoCarPage(){
        clickElement(mainPage.buttonOtomobilPage);
        waitForPageLoad(mainPage.copyrightText);
    }
    public void controlURL(){
        checkURlIsTrue(findByElement(mainPage.buttonOtomobilPage).getAttribute("href"));
    }
    public void goToSpesificCarBrand(){
        clickElement(mainPage.buttonSpesificCarOpel);
        waitForPageLoad(mainPage.copyrightText);
    }

}
