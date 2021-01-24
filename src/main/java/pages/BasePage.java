package pages;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    BasePage() {
        waitForPageLoad();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void waitForPageLoad() {
        new WebDriverWait(DriverManager.getDriver(), 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    //TODO: investigate verify method
    //public abstract boolean verify();
}
