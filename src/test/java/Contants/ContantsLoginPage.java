package Contants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsLoginPage {

    final WebDriver driver;

    @FindBy(how = How.ID,using = "username")
    public WebElement username;
    @FindBy(how = How.ID,using = "password")
    public WebElement password;
    @FindBy(how = How.ID,using = "userLoginSubmitButton")
    public WebElement loginButton;
    @FindBy(how = How.CSS,using = "[ng-show='session\\.user'] .ng-binding")
    public WebElement successUserPage;

    @FindBy(how = How.XPATH,using = "/html//form[@id='loginForm']/dl/dd[1]/label[@class='error']")
    public WebElement errorEmptyUsernameInputArea;

    @FindBy(how = How.XPATH,using = "/html//form[@id='loginForm']//label[@class='error']")
    public WebElement errorEmptyPasswordInputArea;

    @FindBy(how = How.CSS,using = ".error")
    public WebElement errorWrongEmailPassword;

    public ContantsLoginPage(WebDriver webDriver) {
        driver = webDriver;
    }
}
