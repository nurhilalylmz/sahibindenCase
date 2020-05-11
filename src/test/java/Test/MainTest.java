package Test;

import Page.LoginPage;
import Page.MainPage;
import Page.SearchPage;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    SearchPage searchPage;


    @Test(groups = "login", priority = 0)
    public void successLogin() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        mainPage.closePopup();
        loginPage.goToLoginPage()
                .login("testhilaltest@gmail.com", "testhilal34")
                .checkUserMainPage("https://banaozel.sahibinden.com/", "Üyeliğim");

    }

    @Test(groups = "login", priority = 1)
    public void wrongInformationTextLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("testhilaltest12@gmail.com", "testhi54lal34")
                .checkTrueLogin("testhilaltest12@gmail.com", "testhi54lal34", "E-posta adresiniz, şifreniz veya kullanıcı adınız hatalı.", driver.getCurrentUrl());

    }

    @Test(groups = "login", priority = 2)
    public void emptyEmailLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("", "testhilal34")
                .checkTrueLogin("", "testhilal34", "E-posta adresinizi veya kullanıcı adınızı girin.", "");
    }

    @Test(groups = "login", priority = 3)
    public void emptyPasswordLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("testhilaltest@gmail.com", "")
                .checkTrueLogin("testhilaltest@gmail.com", "", "Şifrenizi girin.", "");
    }

    @Test(groups = "login", priority = 4)
    public void emptyAllTextFieldsLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("", "")
                .checkTrueLogin("", "", "E-posta adresinizi veya kullanıcı adınızı girin.", "");
    }

    @Test(groups = "travelPage")
    public void successGoToSpesificCarPage() {
        mainPage = new MainPage(driver);

        mainPage.closePopup()
                .checkHomepage("Tüm vitrin ilanlarını göster")
                .goToVasitaPage("Vasıta Vitrin")
                .goToRentCarPage("Kiralık Araçlar Vitrin")
                .gotoCarPage("Otomobil")
                .controlURL("href")
                .goToSpesificCarBrand(10, "Opel");

    }

    @Test(groups = "filter")
    public void successFilterWithSpesificChoice(){
        searchPage = new SearchPage(driver);
        driver.navigate().to("https://www.sahibinden.com/kiralik-araclar-otomobil-opel");
        //Search sayfasında yapılan işlemler burada yer alır.
        searchPage.clickDropdownListAddressElement("İstanbul (Tümü)")
                .writeInputMaxValue("100")
                .clickDropdownListVitesElement()
                .clickSearchButton();
    }

}
