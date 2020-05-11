package Page;

import Contants.ContantsLoginPage;
import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseMethods {


    ContantsLoginPage loginPage = PageFactory.initElements(driver, ContantsLoginPage.class);
    ContantsMainPage mainPage = PageFactory.initElements(driver, ContantsMainPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        waitElementToClickable(mainPage.buttongotoLogin);
        clickElement(mainPage.buttongotoLogin);
        return new LoginPage(driver);
    }

    public LoginPage login(String email, String password) {
        waitForPageLoad(mainPage.copyrightText);
        loginPage.username.clear();
        writeText(loginPage.username, email);
        loginPage.password.clear();
        writeText(loginPage.password, password);
        clickElement(loginPage.loginButton);
        return new LoginPage(driver);
    }

    public LoginPage checkUserMainPage(String expectingUrl, String controlPageText) {
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertEquals(driver.getCurrentUrl(), expectingUrl, "İstenen sayfada olunmadığı görüldü");
        Assert.assertTrue(loginPage.successUserPage.getText().equals(controlPageText), "Giriş yapamadınız!");
        return new LoginPage(driver);
    }
    public LoginPage checkTrueLogin(String email,String password,String expectedText,String expectedURL){
        if(email.isEmpty()){
            Assert.assertEquals(loginPage.errorEmptyUsernameInputArea.getText(),expectedText);
        }
        else if (email.isEmpty()&&password.isEmpty()){
            Assert.assertEquals(loginPage.errorEmptyUsernameInputArea.getText(),expectedText);
        }
        else if (password.isEmpty()){
            Assert.assertEquals(loginPage.errorEmptyPasswordInputArea.getText(),expectedText);
        }
        else if((!email.isEmpty()&&!password.isEmpty())&&driver.getCurrentUrl()!=expectedURL){
            Assert.assertEquals(loginPage.errorWrongEmailPassword.getText(),expectedText);
        }
        return new LoginPage(driver);
    }

}
