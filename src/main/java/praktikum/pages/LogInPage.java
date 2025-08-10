package praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.util.EnvConfig;

public class LogInPage {
    private static WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginEmailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By loginPasswordField = By.xpath(".//input[@type='password']");
    private final By forgotPasswordButton = By.xpath("//a[@href='/forgot-password']");
    private final By loginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By signupButtonLoginPage = By.cssSelector(".Auth_link__1fOlj");
    private final By loginForm = By.cssSelector(".Auth_form__3qKeq.mb-20");

    public void fillInEmailLoginForm(String email) {
        driver.findElement(loginEmailField).sendKeys(email);
    }
//    public void fillInEmailSignupForm(String email) {
//        driver.findElement(emailField).sendKeys(email);
//    }

    public void fillInPasswordLoginForm(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickLoginButtonLoginPage() {
        driver.findElement(loginButton).click();
    }

    public void clickSignUpButtonOnLoginPage() {
        driver.findElement(signupButtonLoginPage).click();
    }

    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }
    public void checkIfLoginFormIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginForm).isDisplayed());
    }

}
