package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.cssSelector("input.text.input__textfield.text_type_main-default");
    private final By recoverPasswordButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    @Step("Заполенение поля email")
    public void fillInEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Клик на кнопку 'Восстановить пароль'")
    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }
}
