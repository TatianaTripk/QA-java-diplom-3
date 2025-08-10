package praktikum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

public class ConstructorTests {
    public WebDriver driver;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void bunSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        mainPage.checkIfBunSectionIsDisplayed();
    }

    @Test
    public void sauceSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSauceButton();
        mainPage.checkIfSauceSectionIsDisplayed();
    }

    @Test
    public void fillingSectionTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingButton();
        mainPage.checkIfFillingSectionIsDisplayed();
    }
}
