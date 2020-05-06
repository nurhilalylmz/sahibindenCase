package Contants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ContantsSearchPage {
    final WebDriver driver;

    @FindBy(how= How.CSS,using = ".address-search-list  ul > li:nth-of-type(1)")
    public WebElement selectAddressIstanbulTumu;

    @FindBy(how= How.CSS,using = "input[name='price_max']")
    public WebElement inputMaxPrice;

    @FindBy(how= How.ID,using = "_cllpsID_a55422")
    public WebElement showButtonVites;

    @FindBy(how= How.CSS,using = "a[title='Otomatik']")
    public WebElement selectVitesOtomatik;

    @FindBy(how= How.CSS,using = ".search-submit")
    public WebElement buttonSearch;

    @FindBy(how= How.CLASS_NAME,using = "faceted-select")
    public WebElement addressListDropDown;

    @FindBy(how= How.CLASS_NAME,using = "collapse-pane")
    public WebElement buttonAddressListDropDownClose;

    @FindBy(how= How.ID,using = "_cllpsID_a55414")
    public WebElement dropdownMotorHacmi;

    @FindBy(how= How.XPATH,using = "//li[@data-address='city']/a")
    public WebElement afterSelectedTownText;

    public ContantsSearchPage(WebDriver webDriver) {
        driver = webDriver;
    }
}

