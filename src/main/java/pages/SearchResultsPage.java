package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "(//span[@class='goods-tile__title'])[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[@class='search-nothing__wrap']")
    private WebElement nothingFoundMessage;

    @FindBy(xpath = "//div[@class='goods-tile']//span[@class='goods-tile__price-value']")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//select[@_ngcontent-c22]")
    private WebElement sortByCheckBox;

    @FindBy(xpath = "(//option)[2]")
    private WebElement sortByAscending;

    @FindBy(xpath = "(//option)[3]")
    private WebElement sortByDescending;

    public void clickOnTheFirstProduct() {
        firstProduct.click();
    }

    public void clickOnSortPriceByAscending() {
        sortByCheckBox.click();
        sortByAscending.click();
        waitForPageLoad();
    }

    public void clickOnSortPriceByDescending() {
        sortByCheckBox.click();
        sortByDescending.click();
        waitForPageLoad();
    }

    public boolean nothingFoundMessageIsShown() {
        return nothingFoundMessage.isDisplayed();
    }

    public List<Integer> getPrices() {
        List<Integer> result = new ArrayList<>();

        for (WebElement element : productPrice) {
            result.add(Integer.parseInt((element.getText().replaceAll(" ", ""))));
        }

        return result;
    }

    public boolean isPricesSortedByAscending() {
        return Ordering.natural().isOrdered(getPrices());
    }

    public boolean isPricesSortedByDescending() {
        return Ordering.natural().reverse().isOrdered(getPrices());
    }
}
