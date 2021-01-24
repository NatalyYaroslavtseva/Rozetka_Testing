package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

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

//    public RegistrationFormPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(this.driver, this);
//    }

    //@Override
    public boolean verify() {
        return false;
    }

    public String randomTenDigitsNumber() {
        String number = String.valueOf((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
        return number;
    }

    public RegistrationFormPage fillNameSurnamePass(Map<String, String> formFields) {
        nameInputField.sendKeys(formFields.get("name"));
        surnameInputField.sendKeys(formFields.get("surname"));
        passwordInputField.sendKeys(formFields.get("password"));
        return this;
    }

    public RegistrationFormPage fillPhoneAndClickEmail(){
        phoneInputField.sendKeys(randomTenDigitsNumber());
        emailInputField.click();
        return this;
    }


    public void registerButtonClick() {
        registerButton.click();
    }
}
