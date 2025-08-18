package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    private final WebDriver driver;

    private final By loginEmailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By loginPasswordField = By.xpath(".//input[@type='password']");
    private final By forgotPasswordButton = By.xpath("//a[@href='/forgot-password']");
    private final By loginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By signupButtonLoginPage = By.cssSelector(".Auth_link__1fOlj");
    private final By loginForm = By.cssSelector(".Auth_form__3qKeq.mb-20");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля email")
    public void fillInEmailLoginForm(String email) {
        WebElement emailField = driver.findElement(loginEmailField);
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void fillInPasswordLoginForm(String password) {
        WebElement passwordField = driver.findElement(loginPasswordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButtonLoginPage() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickSignUpButtonOnLoginPage() {
        driver.findElement(signupButtonLoginPage).click();
    }

    @Step("Клик на кнопку 'Восстановить пароль'")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Проверка отображения формы авторизации")
    public void checkLoginFormIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginForm).isDisplayed());
    }

}
