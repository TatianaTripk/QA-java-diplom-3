package praktikum.tests;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            startYandexBrowser();
        } else {
            startChrome();
        }
    }

    private void startYandexBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program files\\webdrivers\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Admin\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    private void startChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program files\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("109");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }
}
