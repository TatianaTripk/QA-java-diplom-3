package praktikum.tests;

import io.qameta.allure.Description;
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
    @Description("Переход к разделу «Булки» в конструкторе")
    public void bunSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        mainPage.checkBunSectionIsActive();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Переход к разделу «Соусы» в конструкторе")
    public void sauceSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        mainPage.checkSauceSectionIsActive();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Переход к разделу «Начинки» в конструкторе")
    public void fillingSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingButton();
        mainPage.checkFillingSectionIsActive();
    }
}
