package Test;

import Page.LoginPage;
import Page.MainPage;
import Page.SearchPage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class MainTest extends BaseTest
{
    LoginPage loginPage;
    MainPage mainPage;
    SearchPage searchPage;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void Main(){
        loginPage=new LoginPage(driver);
        mainPage=new MainPage(driver);
        searchPage=new SearchPage(driver);

        //Sayfa ilk açıldığında gelen pop-up'ı kapatır.
        mainPage.closePopup();


        //Main sayfada yapılan işlemler burada yer alır.
        //mainPage.gotoHomepage();
        mainPage.checkHomepage().
                goToVasitaPage().
                goToRentCarPage().
                gotoCarPage().
                controlURL().
                goToSpesificCarBrand();

        loginPage.goToLoginPage().
                login().
                checkUserMainPage();


        //Serach sayfasında yapılan işlemler burada yer alır.
        searchPage.callFilterList();
    }
}
