package Page;

import Contants.ContantsLoginPage;
import Contants.ContantsMainPage;
import Methods.BaseMethods;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
        writeText(loginPage.username, email);
        writeText(loginPage.password, password);
        clickElement(loginPage.loginButton);
        return new LoginPage(driver);
    }

    public LoginPage checkUserMainPage(String expectingUrl, String controlPageText) {
        waitForPageLoad(mainPage.copyrightText);
        checkURlIsTrue(expectingUrl);
        Assert.assertTrue("Giriş yapamadınız!", loginPage.successUserPage.getText().equals(controlPageText));
        return new LoginPage(driver);
    }

}
