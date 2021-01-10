package Cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FirstProductPage;
import pages.HomePage;
import pages.RegistrationFormPage;
import pages.SearchResultsPage;

import java.util.Map;

import static driver.DriverManager.getDriver;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    @Given("The user open Rozetka website")
    public void openRozetkaWebsite() {
        new HomePage(getDriver()).openRozetkaWebsite();
    }

    @When("The user enter to the search-field {string} and click Enter")
    public void enterToTheSearchField(String keyword) {
        new HomePage(getDriver())
                .enterToTheSearchField(keyword);
    }

    @Then("The user open first product from found products")
    public void clickOnTheFirstProduct() {
        new SearchResultsPage(getDriver())
                .clickOnTheFirstProduct();
    }

    @Then("The title of the product should contain {string}")
    public void theTitleOfTheProductShouldContain(String expectedTitleOfTheProduct) {
        final String actualTitleOfTheProduct = new FirstProductPage(getDriver())
                .getNameOfProduct();

        assertTrue("The title of the product does not contain the search words", actualTitleOfTheProduct.contains(expectedTitleOfTheProduct));
    }

    @When("The user click on the 'Buy' button")
    public void theUserClickOnTheBuyButton() {
        new FirstProductPage(getDriver())
                .clickOnBuyButton();
    }

    @Then("The cart is opened")
    public void theCartIsOpened() {
        final boolean actual = new FirstProductPage(getDriver())
                .cartIsOpened();

        assertTrue("The cart is not opened", actual);
    }

    @When("The user open the registration form")
    public void theUserOpenTheRegistrationForm() {
        new HomePage(getDriver())
                .openTheRegistrationForm();
    }

    @When("The user fill fields:")
    public void theUserFillFields(DataTable informationAboutUser) {
        Map<String, String> informationAboutUserMap = informationAboutUser.asMap(String.class, String.class);

        new RegistrationFormPage(getDriver())
                .fillForm(informationAboutUserMap);
    }

    @Then("No products is shown in search result")
    public void noProductsIsShownInSearchResult() {
        final boolean actual = new SearchResultsPage(getDriver())
                .nothingFoundMessageIsShown();

        assertTrue("The message about no search results is not shown", actual);
    }

    @When("The user sort products by price ascending")
    public void theUserSortProductsByPriceAscending() {
        new SearchResultsPage(getDriver())
                .clickOnSortPriceByAscending();
    }

    @When("The user sort products by price descending")
    //@When("The user sort products by price \"?(ascending|descending)\"?")
    public void theUserSortProductsByPriceDescending() {
        new SearchResultsPage(getDriver())
                .clickOnSortPriceByDescending();
    }

    @Then("The products are sorted by price ascending")
    public void theProductsAreSortedByPriceAscending() {
        final boolean actual = new SearchResultsPage(getDriver())
                .isPricesSortedByAscending();

        assertTrue("Prices are not sorted by ascending", actual);
    }

    @Then("The products are sorted by price descending")
    public void theProductsAreSortedByPriceDescending() {
        final boolean actual = new SearchResultsPage(getDriver())
                .isPricesSortedByDescending();

        assertTrue("Prices are not sorted by descending", actual);
    }
}
