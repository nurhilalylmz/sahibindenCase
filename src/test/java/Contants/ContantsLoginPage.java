package Contants;

import org.openqa.selenium.By;

public class ContantsLoginPage {
    public By username=By.id(("username"));
    public By password=By.id("password");
    public By loginButton=By.id("userLoginSubmitButton");
    public By successUserPage=By.cssSelector("[ng-show='session\\.user'] .ng-binding");
}
