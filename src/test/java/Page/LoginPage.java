package Page;

import Contants.ContantsLoginPage;
import Contants.ContantsMainPage;
import Methods.BaseMethods;

public class LoginPage extends BaseMethods {

    String email ="testhilaltest@gmail.com";
    String password ="testhilal34";
    String expectingUrl="https://banaozel.sahibinden.com/";

    ContantsLoginPage loginPage=new ContantsLoginPage();
    ContantsMainPage mainPage=new ContantsMainPage();


    public void goToLoginPage(){
        waitForPageLoad(mainPage.copyrightText);
        clickAnywhereOnPage();
        waitElementToClickable(mainPage.buttongotoLogin);
        clickElement(mainPage.buttongotoLogin);
    }
    public void login(){
            waitForPageLoad(mainPage.copyrightText);
            writeText(loginPage.username,email);
            waitSeconds(2);
            writeText(loginPage.password,password);
            waitSeconds(2);
            clickElement(loginPage.loginButton);
            waitSeconds(2);
        }

    public void checkUserMainPage(){
        waitForPageLoad(mainPage.copyrightText);
        checkURlIsTrue(expectingUrl);
    }

}
