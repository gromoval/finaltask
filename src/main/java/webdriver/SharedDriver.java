package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                DriverFactory.addDriver(driver);
            }
        }
    }
}