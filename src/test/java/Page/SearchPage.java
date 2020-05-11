package Page;

import Contants.ContantsMainPage;
import Contants.ContantsSearchPage;
import Methods.BaseMethods;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseMethods {
    ContantsSearchPage searchPage= PageFactory.initElements(driver, ContantsSearchPage.class);
    ContantsMainPage mainPage=PageFactory.initElements(driver, ContantsMainPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage clickSearchButton(){
        clickElement(searchPage.buttonSearch);
        waitSeconds(5);
        return new SearchPage(driver);
    }
    public SearchPage clickDropdownListAddressElement(String controlText){
        waitForPageLoad(mainPage.copyrightText);
        clickElement(searchPage.addressListDropDown);
        waitSeconds(2);
        clickElement(searchPage.selectAddressIstanbulTumu);
        clickElement(searchPage.buttonAddressListDropDownClose);
        Assert.assertTrue(searchPage.afterSelectedTownText.getText().contains(controlText)
                        , "İstanbul(Tümü) Kategorisine tıklanamadı.");
        return new SearchPage(driver);
    }
    public SearchPage writeInputMaxValue(String maxValue){
        writeText(searchPage.inputMaxPrice,maxValue);
        return new SearchPage(driver);
    }
    public SearchPage clickDropdownListVitesElement(){
        scrollPageWithJavaScript(searchPage.dropdownMotorHacmi);
        clickElement(searchPage.showButtonVites);
        clickElement(searchPage.selectVitesOtomatik);
        Assert.assertFalse((searchPage.selectVitesOtomatik).isSelected()
                        , "Otomatik Vites Kategorisine tıklanamadı.");
        return new SearchPage(driver);
    }
}
