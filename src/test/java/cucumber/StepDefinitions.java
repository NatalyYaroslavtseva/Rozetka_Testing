package cucumber;

import driver.DriverManager;
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

    @When("The user click on the 'Buy' button")
    public void theUserClickOnTheBuyButton() {
        new FirstProductPage().clickOnBuyButton();
    }

    @When("The user click on the 'Register' button")
    public void theUserClickOnTheRegisterButton() {
        new RegistrationFormPage().clickOnRegisterButton();
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
        DriverManager.getDriver();
    }

    @When("The user fill 'Phone' field and click on 'email' field")
    public void theUserFillPhoneFieldAndClickOnEmailField() {
        new RegistrationFormPage()
                .fillPhoneAndClickEmail();
    }

    @When("The user click on the 'password' field")
    public void theUserClickOnThePasswordField() {
        new RegistrationFormPage().clickPasswordField();
    }

    @When("The user open first product from found products")
    public void clickOnTheFirstProduct() {
        new SearchResultsPage().clickOnTheFirstProduct();
    }

    @Then("The title of the product should contain {string}")
    public void theTitleOfTheProductShouldContain(String expectedTitleOfTheProduct) {
        final String actualTitleOfTheProduct = new FirstProductPage()
                .getNameOfProduct();

        assertTrue("The title of the product does not contain the search words", actualTitleOfTheProduct.contains(expectedTitleOfTheProduct));
    }

    @Then("The cart is opened")
    public void theCartIsOpened() {
        final boolean actual = new FirstProductPage().cartIsOpened();

        assertTrue("The cart is not opened", actual);
    }

    @Then("No products is shown in search result")
    public void noProductsIsShownInSearchResult() {
        final boolean actual = new SearchResultsPage().nothingFoundMessageIsShown();

        assertTrue("The message about no search results is not shown", actual);
    }

    @Then("^The products are sorted by price \"?(ascending|descending)\"?$")
    public void theProductsAreSortedByPrice(String type) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.waitForPageLoad();
        boolean actual = false;
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

    @Then("The user check the {string} is invoked")
    public void iCheckTheDefinedPageInvoked(String pageName) {
        boolean actual = false;
        switch (pageName) {
            case "Registration Form page":
                actual = new RegistrationFormPage().verify();
                break;
            case "Search Result page":
                actual = new SearchResultsPage().verify();
                break;
        }

        assertTrue(String.format("The '%s' is not invoked", pageName), actual);
    }

    @Then("The user check that proper error message under the 'email' field is displayed:")
    public void theUserCheckThatProperErrorMessageUnderTheEmailFieldIsDisplayed(String messagePattern) {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        boolean actualState = registrationFormPage.isValidationMessageDisplayed() &&
                (registrationFormPage.getTextValidationEmailMessage().equals(messagePattern));

        assertTrue(String.format("The expected error message with text '%s' was not displayed.", messagePattern), actualState);
    }

    @Then("The user check the 'password' field is error-highlighted")
    public void theUserCheckThePasswordFieldIsErrorHighlighted() {
        final boolean actual = new RegistrationFormPage().isPasswordFieldErrorHighlighted();

        assertTrue("The 'password' field is not error-highlighted", actual);
    }
}
