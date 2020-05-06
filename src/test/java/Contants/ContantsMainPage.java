package Contants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsMainPage {

    final WebDriver webDriver;

    @FindBy(how = How.LINK_TEXT,using = "Vasıta")
    public WebElement buttongotoCarPage ;

    @FindBy(how = How.LINK_TEXT,using = "Kiralık Araçlar")
    public WebElement buttongotoRentCarPage ;

    @FindBy(how = How.LINK_TEXT,using = "Giriş Yap")
    public WebElement buttongotoLogin ;

    @FindBy(how = How.CLASS_NAME,using ="logo")
    public WebElement buttongotoHomepage;

    @FindBy(how = How.CSS,using =".showcase.uiBox > h3")
    public WebElement textCauseHomePage;

    @FindBy(how = How.CSS,using =".copyright")
    public WebElement copyrightText;

    @FindBy(how = How.CSS,using ="[title='Otomobil']")
    public WebElement buttonOtomobilPage;

    @FindBy(how = How.XPATH,using ="/html//div[@id='searchCategoryContainer']//ul//a[@title='Opel']")
    public WebElement buttonSpesificCarOpel;

    @FindBy(how = How.CSS,using =".services-categories > .splash-360-home")
    public WebElement splashMainPage;

    @FindBy(how = How.XPATH,using ="/html//div[@id='container']/div//h3[.='Vasıta Vitrin']")
    public WebElement vasitaPageControl;

    @FindBy(how = How.CSS,using =".showcase-classifieds h3")
    public WebElement rentPageControl;

    @FindBy(how = How.CSS,using ="a[title='Otomobil'] > span")
    public WebElement carPageControl;

    @FindBy(how = How.CSS,using ="span[title='Opel Kiralık Araçlar']")
    public WebElement textSpesificCarOpel;

    @FindBy(how = How.CLASS_NAME,using ="jspTrack")
    public WebElement scrollBarInnerList;

    public ContantsMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
