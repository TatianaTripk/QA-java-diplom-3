package praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    private WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By resetPasswordForm = By.xpath("//div[@class='Auth_login__3hAey']");

    public void checkIfResetPasswordFormIsDisplayed() {
        Assert.assertTrue(driver.findElement(resetPasswordForm).isDisplayed());
    }
}
