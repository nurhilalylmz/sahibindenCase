package Test;
import Page.LoginPage;
import Page.MainPage;
import Page.SearchPage;
import org.testng.annotations.Test;

public class MainTest extends BaseTest
{
    LoginPage loginPage;
    MainPage mainPage;
    SearchPage searchPage;


    @Test
    public void Main(){
        loginPage=new LoginPage(driver);
        mainPage=new MainPage(driver);
        searchPage=new SearchPage(driver);

        //Sayfa ilk açıldığında gelen pop-up'ı kapatır.
        mainPage.closePopup();

        //Login sayfasında yapılacak işlemler altta yer alır.
//           loginPage.goToLoginPage()
//          .login("testhilaltest@gmail.com","testhilal34")
//                   .checkUserMainPage("https://banaozel.sahibinden.com/","Üyeliğim");

        //Main sayfada yapılan işlemler burada yer alır.
        //mainPage.gotoHomepage();
        mainPage.checkHomepage("Anasayfa Vitrini")
        .goToVasitaPage("Vasıta Vitrin")
        .goToRentCarPage("Kiralık Araçlar Vitrin")
        .gotoCarPage("Otomobil")
        .controlURL("href")
        .goToSpesificCarBrand(400,10,"Opel");


        //Serach sayfasında yapılan işlemler burada yer alır.
        searchPage.clickDropdownListAddressElement("İstanbul (Tümü)")
                .writeInputMaxValue("100")
                .clickDropdownListVitesElement()
                .clickSearchButton();
    }


}
