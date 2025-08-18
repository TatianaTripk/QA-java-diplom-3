package praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.model.User;
import praktikum.pages.LogInPage;
import praktikum.pages.MainPage;
import praktikum.pages.SignUpPage;
import praktikum.steps.UserSteps;

public class SignupTests {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver;
    private Faker faker = new Faker();
    private boolean isUserCreated = false;
    private User user = new User();
    private UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация пользователя")
    public void successfulSignupTest() {
        driver = driverFactory.getDriver();

        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        user.setName(faker.name().firstName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(6, 10));

        mainPage.openMainPage();
        mainPage.clickLowerLoginButton();
        logInPage.clickSignUpButtonOnLoginPage();
        signUpPage.fillInNameSignupForm(user.getName());
        signUpPage.fillInEmailSignupForm(user.getEmail());
        signUpPage.fillInPasswordSignUpForm(user.getPassword());
        signUpPage.clickSignUpButtonOnSignupPage();
        logInPage.checkLoginFormIsDisplayed();
        isUserCreated = true;
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Ошибка при регистрации с невалидным паролем")
    public void invalidPasswordSignupTest() {
        driver = driverFactory.getDriver();

        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        user.setName(faker.name().firstName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(4, 5));

        mainPage.openMainPage();
        mainPage.clickLowerLoginButton();
        logInPage.clickSignUpButtonOnLoginPage();
        signUpPage.fillInNameSignupForm(user.getName());
        signUpPage.fillInEmailSignupForm(user.getEmail());
        signUpPage.fillInPasswordSignUpForm(user.getPassword());
        signUpPage.clickSignUpButtonOnSignupPage();
        signUpPage.checkPasswordErrorIsDisplayed();
        isUserCreated = false;
    }

    @After
    public void tearDown() {
        if (isUserCreated) {
            ValidatableResponse loginResponse = userSteps.loginUser(user);
            System.out.println("Полный ответ при логине: " + loginResponse.extract().asString());
            String token = loginResponse.extract().path("accessToken");
            user.setToken(token);
            userSteps.deleteUser(user);
        }
    }
}
