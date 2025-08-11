package praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.util.EnvConfig;

public class SignUpPage {
    private static WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @name='name' and @type='text']");
    private final By emailField = By.xpath("(//input[@class='text input__textfield text_type_main-default' and @name='name'])[2]");
    private final By passwordField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private final By signUpButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By signupPageLoginButton = By.cssSelector(".Auth_link__1fOlj");

    private final By passwordError = By.cssSelector(".input__error.text_type_main-default");

    public void fillInNameSignupForm(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillInEmailSignupForm(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillInPasswordSignUpForm(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void fillInInvalidPasswordSignUpForm() {
        driver.findElement(passwordField).sendKeys(EnvConfig.INVALID_PASSWORD);
    }

    public void clickSignUpButtonOnSignupPage() {
        driver.findElement(signUpButton).click();
    }

    public void checkIfPasswordErrorIsDisplayed() {
        Assert.assertTrue(driver.findElement(passwordError).isDisplayed());
    }

    public void clickLoginButton() {
        driver.findElement(signupPageLoginButton).click();
    }
}
