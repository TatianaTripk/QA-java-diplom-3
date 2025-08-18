package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @name='name' and @type='text']");

    private final By emailField = By.xpath("(//input[@class='text input__textfield text_type_main-default' and @name='name'])[2]");
    private final By passwordField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private final By signUpButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By signupPageLoginButton = By.cssSelector(".Auth_link__1fOlj");
    private final By passwordError = By.cssSelector(".input__error.text_type_main-default");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля имя")
    public void fillInNameSignupForm(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнение поля email")
    public void fillInEmailSignupForm(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void fillInPasswordSignUpForm(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие кнопки 'Зарегистрироваться'")
    public void clickSignUpButtonOnSignupPage() {
        driver.findElement(signUpButton).click();
    }

    @Step("Проверка отображения ошибки 'Некорректный пароль'")
    public void checkPasswordErrorIsDisplayed() {
        Assert.assertTrue(driver.findElement(passwordError).isDisplayed());
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(signupPageLoginButton).click();
    }
}
