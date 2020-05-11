package Test;

import Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void beginTest() {
        BasePage.setBrowser("https://www.sahibinden.com/");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        BaseTest.driver = webDriver;
    }
}
