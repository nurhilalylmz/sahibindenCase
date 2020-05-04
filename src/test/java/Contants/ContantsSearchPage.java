package Contants;

import org.openqa.selenium.By;

public class ContantsSearchPage {
    public By selectAddressIstanbulTumu=By.cssSelector(".address-search-list  ul > li:nth-of-type(1)");
    public By inputMaxPrice=By.cssSelector("input[name='price_max']");
    public By showButtonVites=By.id("_cllpsID_a55422");
    public By selectVitesOtomatik=By.cssSelector("a[title='Otomatik']");
    public By buttonSearch=By.cssSelector(".search-submit");
    public By addressListDropDown=By.className("faceted-select");
    public By buttonAddressListDropDownClose=By.className("collapse-pane");
    public By dropdownMotorHacmi=By.id("_cllpsID_a55414");
    public By afterSelectedTownText=By.xpath("//li[@data-address='city']/a");

}
