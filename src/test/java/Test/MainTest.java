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


    @Test(groups = "login",priority = 0)
    public void successLogin(){
        loginPage=new LoginPage(driver);
        mainPage=new MainPage(driver);
        //Sayfa ilk açıldığında gelen pop-up'ı kapatır.
        mainPage.closePopup();
        //Login sayfasında yapılacak işlemler altta yer alır.
           loginPage.goToLoginPage()
          .login("testhilaltest@gmail.com","testhilal34")
                   .checkUserMainPage("https://banaozel.sahibinden.com/","Üyeliğim");
    }
    @Test(groups = "login",priority = 1)
    public void incorrectInformationLogin(){
        loginPage=new LoginPage(driver);
       // Login sayfasında yapılacak işlemler altta yer alır.
           loginPage
          .login("testhilaltest@gmail.com","123456")
                   .checkTrueLogin("testhilaltest@gmail.com","123456","E-posta adresiniz, kullanıcı adınız veya şifreniz hatalı.","https://banaozel.sahibinden.com/");

    }
    @Test(groups = "login",priority = 2)
    public void emptyUsernameLogin(){
        loginPage=new LoginPage(driver);
           loginPage
         .login("","testhilal34")
                  .checkTrueLogin("","testhilal34","E-posta adresinizi veya kullanıcı adınızı girin.","");
    }
    @Test(groups = "login",priority = 3)
    public void emptyPasswordLogin(){
        loginPage=new LoginPage(driver);
        //Login sayfasında yapılacak işlemler altta yer alır.
        loginPage
                .login("testhilaltest@gmail.com","")
                .checkTrueLogin("testhilaltest@gmail.com","","Şifrenizi girin.","");
    }
    @Test(groups = "login",priority = 4)
    public void emptyInputTextLogin(){
        loginPage=new LoginPage(driver);
        loginPage
                .login("","")
                .checkTrueLogin("","","E-posta adresinizi veya kullanıcı adınızı girin.","");

    }

    @Test(groups = "travelPage")
    public void successGoToSpresificCarPage(){
        mainPage=new MainPage(driver);
        //Sayfa ilk açıldığında gelen pop-up'ı kapatır.
        mainPage.closePopup();
        mainPage.checkHomepage("Tüm vitrin ilanlarını göster")
                .goToVasitaPage("Vasıta Vitrin")
                .goToRentCarPage("Kiralık Araçlar Vitrin")
                .gotoCarPage("Otomobil")
                .controlURL("href")
                .goToSpesificCarBrand(
                        10,
                        "Opel Kiralık Araçlar");
    }

    @Test (groups = "filter")
    public void succesFilter(){
        searchPage=new SearchPage(driver);
        driver.navigate().to("https://www.sahibinden.com/kiralik-araclar-otomobil-opel");
        searchPage.clickDropdownListAddressElement("İstanbul (Tümü)")
                .writeInputMaxValue("100")
                .clickDropdownListVitesElement()
                .clickSearchButton();
    }


}
