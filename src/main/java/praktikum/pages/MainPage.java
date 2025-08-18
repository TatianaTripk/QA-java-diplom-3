package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.util.RestConfig;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private final By upperProfileButton = By.xpath("//p[contains(text(), 'Личный Кабинет')]");
    private final By lowerLoginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    private final By bunButton = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Булки']]");
    private final By sauceButton = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Соусы']]");
    private final By fillingButton = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Начинки']]");
    private final String ACTIVE_SECTION = "tab_tab_type_current__2BEPc";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void openMainPage() {
        driver.get(RestConfig.BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(bunButton));
    }

    @Step("Клик на кнопку 'Личный кабинет'")
    public void clickUpperProfileButton() {
        driver.findElement(upperProfileButton).click();
    }

    @Step("Клик на кнопку 'Войти в аккаунт'")
    public void clickLowerLoginButton() {
        driver.findElement(lowerLoginButton).click();
    }

    @Step("Клик на кнопку 'Булки'")
    public void clickBunButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementBun = wait.until(ExpectedConditions.visibilityOfElementLocated(bunButton));
        wait.until(ExpectedConditions.elementToBeClickable(elementBun));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementBun);
    }

    @Step("Клик на кнопку 'Соусы'")
    public void clickSauceButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementSauce = wait.until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
        wait.until(ExpectedConditions.elementToBeClickable(elementSauce)).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementSauce);
    }

    @Step("Клик на кнопку 'Начинки'")
    public void clickFillingButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementFilling = wait.until(ExpectedConditions.visibilityOfElementLocated(fillingButton));
        wait.until(ExpectedConditions.elementToBeClickable(elementFilling)).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementFilling);
    }

    @Step("Проверка, активен ли раздел 'Булки'")
    public void checkBunSectionIsActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(bunButton, "class", ACTIVE_SECTION));
        String bunClass = driver.findElement(bunButton).getAttribute("class");
        Assert.assertTrue(bunClass.contains(ACTIVE_SECTION));
    }

    @Step("Проверка, активен ли раздел 'Соусы'")
    public void checkSauceSectionIsActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(sauceButton, "class", ACTIVE_SECTION));
        String sauceClass = driver.findElement(sauceButton).getAttribute("class");
        Assert.assertTrue(sauceClass.contains(ACTIVE_SECTION));
    }

    @Step("Проверка, активен ли раздел 'Начинки'")
    public void checkFillingSectionIsActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(fillingButton, "class", ACTIVE_SECTION));
        String fillingClass = driver.findElement(fillingButton).getAttribute("class");
        Assert.assertTrue(fillingClass.contains(ACTIVE_SECTION));
    }
}
