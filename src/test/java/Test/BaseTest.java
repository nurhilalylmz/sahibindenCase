package Test;

import Page.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;
    @Before
    public void beginTest() {
        BasePage.setBrowser("https://www.sahibinden.com/");
    }

    @After
    public void afterTest() {
        if(driver!=null){
            driver.quit();
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver webDriver){
        BaseTest.driver=webDriver;
    }
}
