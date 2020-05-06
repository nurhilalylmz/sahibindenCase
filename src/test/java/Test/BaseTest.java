package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

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
            case 2:
                WebDriverManager.iedriver().setup();
            case 3:
                WebDriverManager.edgedriver().setup();
            case 4:
                System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
            case 5:
                WebDriverManager.firefoxdriver().setup();
        }

    }
    @Before
    public void setupTest() {

        switch (browser){
            case  0 :
                //Chrome ayarlarını yapmak için yeni bir obje nesnesi oluşturulur.
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setExperimentalOption("useAutomationExtension", true);
                //Dil çevirme penceresini kapattırma.
                chromeOptions.addArguments("disable-translate");
                //Browser tam ekranda gösterilir.
                chromeOptions.addArguments("start-maximized");
                //Pop-uplar bloklanır.
                chromeOptions.addArguments("disable-popup-blocking");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(chromeOptions);

            case  1 :
                DesiredCapabilities operacapabilities = DesiredCapabilities.opera();
                ChromeOptions operaOptions = new ChromeOptions();
                operaOptions.setBinary("/path/to/opera");
                operacapabilities.setCapability(ChromeOptions.CAPABILITY, operacapabilities);
                driver = new OperaDriver(operaOptions);


            case 2:
                DesiredCapabilities iecapabilities =  DesiredCapabilities.internetExplorer();
                //Examples
                iecapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                iecapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                iecapabilities.setCapability("allow-blocked-content", true);
                iecapabilities.setCapability("allowBlockedContent", true);
                iecapabilities.setCapability("ignoreProtectedModeSettings", true);
                iecapabilities.setCapability("enablePersistentHover", false);
                //it is used to initialize the IE driver
                driver = new InternetExplorerDriver(iecapabilities);
            case 3:
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.setPageLoadStrategy("PageLoadStrategy.NONE");
                driver=new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
            case 4:
                SafariOptions safariOptions=new SafariOptions();
                driver=new SafariDriver(safariOptions);
                driver.manage().window().maximize();
            case 5:
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        driver.navigate().to("https://www.sahibinden.com/");
    }


    @After
    public void tearDown() {
        if(driver!=null){

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
