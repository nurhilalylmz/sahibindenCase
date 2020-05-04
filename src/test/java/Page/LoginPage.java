package Page;

import Contants.ContantsLoginPage;
import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.junit.Assert;
import org.junit.Test;

public class LoginPage extends BaseMethods {

    String email ="testhilaltest@gmail.com";
    String password ="testhilal34";
    String expectingUrl="https://banaozel.sahibinden.com/";

    ContantsLoginPage loginPage=new ContantsLoginPage();
    ContantsMainPage mainPage=new ContantsMainPage();

    public void goToLoginPage(){
        waitElementToClickable(mainPage.buttongotoLogin);
        clickElement(mainPage.buttongotoLogin);
    }
    public void login(){
            waitForPageLoad(mainPage.copyrightText);
            writeText(loginPage.username,email);
            writeText(loginPage.password,password);
            clickElement(loginPage.loginButton);
        }
    public void checkUserMainPage(){
        waitForPageLoad(mainPage.copyrightText);
        checkURlIsTrue(expectingUrl);
        Assert.assertTrue("Giriş yapamadınız!", getText(loginPage.successUserPage).equals("Üyeliğim"));
    }

}
