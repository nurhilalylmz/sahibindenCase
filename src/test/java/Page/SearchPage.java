package Page;

import Contants.ContantsSearchPage;
import Methods.BaseMethods;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BaseMethods {
    ContantsSearchPage searchPage=new ContantsSearchPage();

    public void fillFiltreChoice(){
        clickElement(searchPage.selectAddressIstanbulTumu);
        waitSeconds(2);
        writeText(searchPage.inputMaxPrice,"100");
        waitSeconds(2);
        clickElement(searchPage.showButtonVites);
        waitSeconds(2);
        waitElementToClickable(searchPage.selectVitesOtomatik);
        clickElement(searchPage.selectVitesOtomatik);
        waitSeconds(2);
        clickElement(searchPage.buttonSearch);
        waitSeconds(2);

    }
}
