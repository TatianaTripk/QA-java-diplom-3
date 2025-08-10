package praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.util.EnvConfig;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By upperProfileButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By lowerLoginButton = By.cssSelector((".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg"));
    private final By bunButton = By.xpath("//span[text()='Булки']/parent::div");
    private final By sauceButton = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingButton = By.xpath("//span[text()='Начинки']/parent::div");
    private final By bunSection = By.xpath("//h2[contains(@class, 'text_type_main-medium') and text()='Булки']");
    private final By sauceSection = By.xpath("//h2[contains(@class, 'text_type_main-medium') and text()='Соусы']");
    private final By fillingSection = By.xpath("//h2[contains(@class, 'text_type_main-medium') and text()='Начинки']");

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void clickUpperProfileButton() {
        driver.findElement(upperProfileButton).click();
    }

    public void clickLowerLoginButton() {
        driver.findElement(lowerLoginButton).click();
    }

    public void clickBunButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bunButton)).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    public void checkIfBunSectionIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(bunSection)).isDisplayed());
    }

    public void checkIfSauceSectionIsDisplayed() {
        Assert.assertTrue(driver.findElement(sauceSection).isDisplayed());
    }

    public void checkIfFillingSectionIsDisplayed() {
        Assert.assertTrue(driver.findElement(fillingSection).isDisplayed());
    }
}
