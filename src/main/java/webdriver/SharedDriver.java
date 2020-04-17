package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class SharedDriver {
    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            try {
                if (System.getProperties().getProperty("webbrowser").equals("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    WebDriver driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    DriverFactory.addDriver(driver);
                }
            } catch (NullPointerException e) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                WebDriver driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                DriverFactory.addDriver(driver);
            }
        }
    }
}