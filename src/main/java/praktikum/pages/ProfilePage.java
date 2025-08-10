package praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private static WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountList = By.cssSelector(".Account_listItem__35dAP");

    public void checkIfAccountlistIsDisplayed() {
        Assert.assertTrue(driver.findElement(accountList).isDisplayed());
    }
}
