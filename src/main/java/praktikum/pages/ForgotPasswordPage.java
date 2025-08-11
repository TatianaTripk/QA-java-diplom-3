package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.util.EnvConfig;

public class ForgotPasswordPage {
    private static WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.cssSelector("input.text.input__textfield.text_type_main-default");
    private final By recoverPasswordButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    public void fillInEmail(String email) {
        driver.findElement(emailField).sendKeys(EnvConfig.VALID_EMAIL);
    }

    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }
}
