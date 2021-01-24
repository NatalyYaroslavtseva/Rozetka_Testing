package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstProductPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = "//button[contains(@class,'button_size_large')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@class='cart-footer']")
    private WebElement cartFooter;

    public String getNameOfProduct() {
        return productTitle.getText();
    }

    public void clickOnBuyButton() {
        productTitle.click();
        buyButton.click();
    }

    public boolean cartIsOpened() {
        return cartFooter.isDisplayed();
    }
}
