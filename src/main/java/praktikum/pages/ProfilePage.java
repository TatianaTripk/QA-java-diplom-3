package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;

    private final By accountList = By.cssSelector(".Account_listItem__35dAP");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка отображения раздела 'Профиль'")
    public void checkAccountListIsDisplayed() {
        Assert.assertTrue(driver.findElement(accountList).isDisplayed());
    }
}
