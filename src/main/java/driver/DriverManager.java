package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (null == driverThreadLocal.get()) {
            switch (System.getProperty("browser", "chrome")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driverThreadLocal.set(new FirefoxDriver());
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driverThreadLocal.set(new EdgeDriver());
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless", "--window-size=1920,1200");
                    driverThreadLocal.set(new ChromeDriver(options));
                }
            }
            driverThreadLocal.get().manage().window().maximize();
            driverThreadLocal.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
