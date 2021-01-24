package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

//    public static WebDriver getDriver() {
//        System.getProperty("browser", "chrome");
//        if (null == driverThreadLocal.get()) {
//            WebDriverManager.chromedriver().setup();
//            driverThreadLocal.set(new ChromeDriver());
//            driverThreadLocal.get().manage().window().maximize();
//            driverThreadLocal.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }
//        return driverThreadLocal.get();
//    }


    public static WebDriver getDriver() {
         if (null == driverThreadLocal.get()) {
            switch (System.getProperty("browser", "chrome")){
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
                    driverThreadLocal.set(new ChromeDriver());
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
