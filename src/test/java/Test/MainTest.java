package Test;
import Methods.BaseMethods;
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
        loginPage=new LoginPage();
        mainPage=new MainPage();
        searchPage=new SearchPage();

        //Sayfa ilk açıldığında gelen pop-up'ı kapatır.
        mainPage.closePopup();

        //Login sayfasında yapılacak işlemler altta yer alır.
//        loginPage.goToLoginPage();
//        loginPage.login();
//        loginPage.checkUserMainPage();

        //Main sayfada yapılan işlemler burada yer alır.
        //mainPage.gotoHomepage();
        mainPage.checkHomepage();
        mainPage.goToVasitaPage();
        mainPage.goToRentCarPage();
        mainPage.gotoCarPage();
        mainPage.controlURL();
        mainPage.goToSpesificCarBrand();

        //Serach sayfasında yapılan işlemler burada yer alır.
        searchPage.callFilterList();
    }
}
