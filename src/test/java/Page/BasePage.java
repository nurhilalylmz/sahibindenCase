package Page;
import Test.BaseTest;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BasePage {
    public static void setBrowser(String url) {
        //chrome driver dizinini belirttik.
        System.setProperty("webdriver.chrome.driver", "properties/webdriver/chromedriver.exe");
        // System.setProperty("","properties\\driver\\geckodriver.exe");
        //Browser ayarları
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Chrome ayarlarını yapmak için yeni bir obje nesnesi oluşturulur.
        ChromeOptions chromeOptions = new ChromeOptions();
        //Browser'ı test modunda çalıştırma.
        chromeOptions.addArguments("test-type");
//        //Dil çevirme penceresini kapattırma.
        chromeOptions.addArguments("disable-translate");
        //Browser tam ekranda gösterilir.
        chromeOptions.addArguments("start-maximized");
        //Pop-uplar bloklanır.
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        //Driver'ımızı setliyoruz.
        BaseTest.setDriver(new ChromeDriver(chromeOptions));
        //URL'e gidilir.
        BaseTest.getDriver().navigate().to(url);

    }
}