package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    private final WebDriver driver;

    private final By resetPasswordForm = By.xpath("//div[@class='Auth_login__3hAey']");

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка отображения формы восстановления пароля")
    public void checkResetPasswordFormIsDisplayed() {
        Assert.assertTrue(driver.findElement(resetPasswordForm).isDisplayed());
    }
}
