package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class FirstProductPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = "//button[contains(@class,'button_size_large')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@class='cart-footer']")
    private WebElement cartFooter;

    @FindBy(xpath = "//rz-product-top")
    private WebElement productTop;

    @Override
    public boolean verify() {
        return productTop.isDisplayed();
    }

    public String getNameOfProduct() {
        return productTitle.getText();
    }

    public void clickOnBuyButton() {
        productTitle.click();
        buyButton.click();
        log.info("'Buy' button has been clicked");
    }

    public boolean cartIsOpened() {
        return cartFooter.isDisplayed();
    }
}
