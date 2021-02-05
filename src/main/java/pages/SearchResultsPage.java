package pages;

import com.google.common.collect.Ordering;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "(//span[@class='goods-tile__title'])[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[@class='catalog-empty']")
    private WebElement nothingFoundMessage;

    @FindBy(xpath = "//div[@class='goods-tile']//span[@class='goods-tile__price-value']")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//select[contains(@class,'select')]")
    private WebElement sortByCheckBox;

    @FindBy(xpath = "(//option)[2]")
    private WebElement sortByAscending;

    @FindBy(xpath = "(//option)[3]")
    private WebElement sortByDescending;

    @Override
    public boolean verify() {
        return firstProduct.isDisplayed();
    }

    public void clickOnTheFirstProduct() {
        if (verify()) {
            firstProduct.click();
            log.info("Clicked on the first product");
        } else
            log.error("Search Result Page was not invoked");
    }

    public void clickOnSortPriceByAscending() {
        sortByCheckBox.click();
        sortByAscending.click();
        log.info("Sort price by 'Ascending' has been applied");
        waitForPageLoad();
    }

    public void clickOnSortPriceByDescending() {
        sortByCheckBox.click();
        sortByDescending.click();
        log.info("Sort price by 'Descending' has been applied");
        waitForPageLoad();
    }

    public boolean nothingFoundMessageIsShown() {
        return nothingFoundMessage.isDisplayed();
    }

    public List<Integer> getPrices() {
//        List<Integer> result = new ArrayList<>();

//        for (WebElement element : productPrice) {
//            result.add(Integer.parseInt((element.getText().replaceAll(" ", ""))));
//        }
//        return result;

        List<Integer> prodPriceInt = productPrice.stream()
                .map(productPriceElement -> Integer.parseInt((productPriceElement.getText().replaceAll(" ", ""))))
                .collect(Collectors.toList());
        log.info("Products have the following prices: {}", prodPriceInt);
        return prodPriceInt;
    }

    public boolean isPricesSortedByAscending() {
        return Ordering.natural().isOrdered(getPrices());
    }

    public boolean isPricesSortedByDescending() {
        return Ordering.natural().reverse().isOrdered(getPrices());
    }
}
