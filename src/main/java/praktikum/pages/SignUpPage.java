package praktikum.pages;

import net.datafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.model.User;
import praktikum.util.EnvConfig;

public class SignUpPage {
    private static WebDriver driver;
    Faker faker = new Faker();
    User user = new User();

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginPageSignUpForm = By.cssSelector(".Auth_link__1fOlj");
    private final By nameField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @name='name' and @type='text']");
    private final By emailField = By.xpath("(//input[@class='text input__textfield text_type_main-default' and @name='name'])[2]");
    private final By passwordField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private final By signUpButton = By.cssSelector(".Auth_link__1fOlj");

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
        driver.findElement(loginPageSignUpForm).click();
    }
}
