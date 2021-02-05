package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

@Slf4j
public class RegistrationFormPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@formcontrolname='surname']")
    private WebElement surnameInputField;

    @FindBy(xpath = "//input[@formcontrolname='phone']")
    private WebElement phoneInputField;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    @FindBy(xpath = "//p[@class='validation-message']")
    private WebElement validationEmailMessage;

    @FindBy(xpath = "//div[@class='modal__content']")
    private WebElement registrationForm;

    @FindBy(xpath = "//fieldset[contains(@class,'error')]")
    WebElement errorHighlightedPasswordField;

    @Override
    public boolean verify() {
        return registrationForm.isDisplayed();
    }

    public String randomTenDigitsNumber() {
        String number = String.valueOf((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
        log.info("Random ten digits number '{}' has been created", number);
        return number;
    }

    public RegistrationFormPage fillNameSurnamePass(Map<String, String> formFields) {
        nameInputField.sendKeys(formFields.get("name"));
        surnameInputField.sendKeys(formFields.get("surname"));
        log.info("Name '{}' and surname '{}' fields has been entered",
                formFields.get("name"), formFields.get("surname"));
        return this;
    }

    public RegistrationFormPage fillPhoneAndClickEmail() {
        phoneInputField.sendKeys(randomTenDigitsNumber());
        log.info("Random phone number has been entered");
        emailInputField.click();
        log.info("Email field has been clicked");
        return this;
    }

    public void clickOnRegisterButton() {
        registerButton.click();
        log.info("Register button has been clicked");
    }

    public boolean isValidationMessageDisplayed(){
        return validationEmailMessage.isDisplayed();
    }

    public String getTextValidationEmailMessage(){
        return validationEmailMessage.getText();
    }

    public void clickPasswordField(){
        passwordInputField.click();
    }

    public boolean isPasswordFieldErrorHighlighted(){
        return errorHighlightedPasswordField.isDisplayed();
    }
}
