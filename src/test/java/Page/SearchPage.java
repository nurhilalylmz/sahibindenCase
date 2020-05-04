package Page;

import Contants.ContantsMainPage;
import Contants.ContantsSearchPage;
import Methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethods {
    ContantsSearchPage searchPage=new ContantsSearchPage();
    ContantsMainPage mainPage=new ContantsMainPage();

    public void callFilterList(){
        searchFilterChoice();
        clickElement(searchPage.buttonSearch);
        waitSeconds(5);
    }
    public void searchFilterChoice(){
        waitForPageLoad(mainPage.copyrightText);
        clickDropdownListAddressElement();
        writeInputMaxValue();
        scrollPageWithJavaScript(searchPage.dropdownMotorHacmi);
        clickDropdownListVitesElement();
    }
    public void clickDropdownListAddressElement(){
        clickElement(searchPage.addressListDropDown);
        clickElement(searchPage.selectAddressIstanbulTumu);
        clickElement(searchPage.buttonAddressListDropDownClose);
        Assert.assertTrue("İstanbul(Tümü) Kategorisine tıklanamadı."
                ,getText(searchPage.afterSelectedTownText).contains("İstanbul (Tümü)"));
    }
    public void writeInputMaxValue(){
        writeText(searchPage.inputMaxPrice,"100");
    }
    public void clickDropdownListVitesElement(){
        clickElement(searchPage.showButtonVites);
        clickElement(searchPage.selectVitesOtomatik);
        Assert.assertFalse("Otomatik Vites Kategorisine tıklanamadı."
                ,findByElement(searchPage.selectVitesOtomatik).isSelected());
    }
}
