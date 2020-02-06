package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static DriverFactory instance;
    private WebDriver driver;

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (instance == null)
            instance = new DriverFactory();
        return instance;
    }

    public WebDriver getDriver(DriverType type) {
        if (driver == null) {
            switch (type) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:\\webdriver_jars\\chromedriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "C:\\webdriver_jars\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case IE:
                    break;
            }
        }
        return driver;
    }
}
