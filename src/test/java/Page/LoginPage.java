package Page;

import Contants.ContantsLoginPage;
import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseMethods {

    String email ="testhilaltest@gmail.com";
    String password ="testhilal34";
    String expectingUrl="https://banaozel.sahibinden.com/";

    ContantsLoginPage loginPage=new ContantsLoginPage();
    ContantsMainPage mainPage=new ContantsMainPage();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(){
        waitElementToClickable(mainPage.buttongotoLogin);
        clickElement(mainPage.buttongotoLogin);
        return new LoginPage(driver);
    }
    public LoginPage login(){
            waitForPageLoad(mainPage.copyrightText);
            writeText(loginPage.username,email);
            writeText(loginPage.password,password);
            clickElement(loginPage.loginButton);
        return new LoginPage(driver);
        }
    public LoginPage checkUserMainPage(){
        waitForPageLoad(mainPage.copyrightText);
        checkURlIsTrue(expectingUrl);
        Assert.assertTrue("Giriş yapamadınız!", getText(loginPage.successUserPage).equals("Üyeliğim"));
        return new LoginPage(driver);
    }

}
