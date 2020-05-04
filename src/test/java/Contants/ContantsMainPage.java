package Contants;

import org.openqa.selenium.By;

public class ContantsMainPage {

    public By buttongotoCarPage = By.linkText("Vasıta");

    public By buttongotoRentCarPage = By.linkText("Kiralık Araçlar");

    public By buttongotoLogin = By.linkText("Giriş Yap");

    public By buttongotoHomepage=By.className("logo");

    public By textCauseHomePage=By.cssSelector(".showcase.uiBox > h3");

    public By copyrightText = By.cssSelector(".copyright");

    public By buttonOtomobilPage=By.cssSelector("[title='Otomobil']");

    public By buttonSpesificCarOpel=By.xpath("/html//div[@id='searchCategoryContainer']//ul//a[@title='Opel']");

    public By splashMainPage=By.cssSelector(".services-categories > .splash-360-home");

    public By vasitaPageControl=By.xpath("/html//div[@id='container']/div//h3[.='Vasıta Vitrin']");

    public By rentPageControl=By.cssSelector(".showcase-classifieds h3");

    public By carPageControl=By.cssSelector("a[title='Otomobil'] > span");

    public By textSpesificCarOpel=By.cssSelector("span[title='Opel Kiralık Araçlar']");

    public By scrollBarInnerList=By.className("jspTrack");

}
