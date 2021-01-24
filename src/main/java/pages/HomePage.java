package pages;

import driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final String ROZETKA_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'user')]")
    private WebElement enterPersonalAccount;

    @FindBy(xpath = "//a[contains(@class,'register-link')]")
    private WebElement registerLink;

    @FindBy(xpath = "//ul[contains(@class,'menu-categories_')]")
    private WebElement leftSideMenu;

    //@Override
    public boolean verify() {
        return leftSideMenu.isDisplayed();
    }

    public void openRozetkaWebsite() {
        DriverManager.getDriver().get(ROZETKA_URL);
    }

    public void enterToTheSearchField(String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
        waitForPageLoad();
    }

    public void openTheRegistrationForm() {
        enterPersonalAccount.click();
        registerLink.click();
        waitForPageLoad();
    }
}
