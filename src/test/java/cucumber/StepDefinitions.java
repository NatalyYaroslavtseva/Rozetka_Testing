package cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FirstProductPage;
import pages.HomePage;
import pages.RegistrationFormPage;
import pages.SearchResultsPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    @Given("The user open Rozetka website")
    public void openRozetkaWebsite() {
        new HomePage().openRozetkaWebsite();
    }

    @When("The user enter to the search-field {string} and click Enter")
    public void enterToTheSearchField(String keyword) {
        new HomePage().enterToTheSearchField(keyword);
    }

    @Then("The user open first product from found products")
    public void clickOnTheFirstProduct() {
        new SearchResultsPage().clickOnTheFirstProduct();
    }

    @Then("The title of the product should contain {string}")
    public void theTitleOfTheProductShouldContain(String expectedTitleOfTheProduct) {
        final String actualTitleOfTheProduct = new FirstProductPage()
                .getNameOfProduct();

        assertTrue("The title of the product does not contain the search words", actualTitleOfTheProduct.contains(expectedTitleOfTheProduct));
    }

    @When("The user click on the 'Buy' button")
    public void theUserClickOnTheBuyButton() {
        new FirstProductPage().clickOnBuyButton();
    }

    @Then("The cart is opened")
    public void theCartIsOpened() {
        final boolean actual = new FirstProductPage().cartIsOpened();

        assertTrue("The cart is not opened", actual);
    }

    @When("The user open the registration form")
    public void theUserOpenTheRegistrationForm() {
        new HomePage().openTheRegistrationForm();
    }

    @When("The user fill fields:")
    public void theUserFillFields(DataTable informationAboutUser) {
        Map<String, String> informationAboutUserMap = informationAboutUser.asMap(String.class, String.class);

        new RegistrationFormPage().fillNameSurnamePass(informationAboutUserMap);
    }

    @Then("No products is shown in search result")
    public void noProductsIsShownInSearchResult() {
        final boolean actual = new SearchResultsPage().nothingFoundMessageIsShown();

        assertTrue("The message about no search results is not shown", actual);
    }

    @When("^The user sort products by price \"?(ascending|descending)\"?$")
    public void theUserSortProductsByPrice(String type) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        switch (type) {
            case "ascending":
                searchResultsPage.clickOnSortPriceByAscending();
                break;
            case "descending":
                searchResultsPage.clickOnSortPriceByDescending();
                break;
        }
    }

    @Then("^The products are sorted by price \"?(ascending|descending)\"?$")
    public void theProductsAreSortedByPrice(String type) {
        boolean actual = false;
        //SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        switch (type) {
            case "ascending":
                actual = new SearchResultsPage()
                        .isPricesSortedByAscending();
                break;
            case "descending":
                actual = new SearchResultsPage()
                        .isPricesSortedByDescending();
                break;
        }
        assertTrue(String.format("Prices are not sorted by %s", type), actual);
    }

    // @Then("The products are sorted by price descending")
    //public void theProductsAreSortedByPriceDescending () {
    //     final boolean actual = new SearchResultsPage(getDriver())
    //             .isPricesSortedByDescending();
//
    //    assertTrue("Prices are not sorted by descending", actual);


    @When("The user fill 'Phone' field and click on 'email' field")
    public void theUserFillPhoneFieldAndClickOnEmailField() {
        new RegistrationFormPage()
                .fillPhoneAndClickEmail();
    }
}
