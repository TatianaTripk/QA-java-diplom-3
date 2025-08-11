package praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

public class ConstructorTests {
    public WebDriver driver;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void bunSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        mainPage.checkIfBunSectionIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void sauceSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        mainPage.checkIfSauceSectionIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingButton();
        mainPage.checkIfFillingSectionIsDisplayed();
    }
}
