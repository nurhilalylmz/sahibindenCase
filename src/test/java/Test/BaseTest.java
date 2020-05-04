package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Collections;

public class BaseTest {

    public static WebDriver driver;
    private static int browser = 0;


    @BeforeClass
    public static void setupClass() {
        switch (browser){
            case  0 :
                WebDriverManager.chromedriver().setup();
            case  1 :
                WebDriverManager.operadriver().setup();
        }

    }

    @Before
    public void setupTest() {
        switch (browser){
            case  0 :
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.setExperimentalOption("useAutomationExtension", true);
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(options);
            case  1 :
                OperaDriver operaDriver = new OperaDriver();
        }

        driver.navigate().to("https://www.sahibinden.com/");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public WebDriver getDriver(){
        return this.driver;
    }
    public void setDriver(WebDriver webDriver){
        this.driver=webDriver;
    }
}
