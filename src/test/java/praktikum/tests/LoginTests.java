package praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.model.User;
import praktikum.pages.*;
import praktikum.steps.UserSteps;

public class LoginTests {
    public WebDriver driver;
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private Faker faker = new Faker();
    private boolean isUserCreated = false;
    private User user = new User();
    private UserSteps userSteps = new UserSteps();

    @Before
    public void startUp() {
        user.setName(faker.name().firstName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(6, 10));
        userSteps.signupUser(user);
        isUserCreated = true;
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт»")
    @Description("Вход в аккаунт по кнопке «Войти в аккаунт» на главной странице")
    public void upperProfileButtonLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.openMainPage();
        mainPage.clickUpperProfileButton();
        logInPage.fillInEmailLoginForm(user.getEmail());
        logInPage.fillInPasswordLoginForm(user.getPassword());
        logInPage.clickLoginButtonLoginPage();
        mainPage.clickUpperProfileButton();
        profilePage.checkAccountListIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Вход в аккаунт по кнопке «Личный кабинет» на главной странице")
    public void lowerLoginButtonLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.openMainPage();
        mainPage.clickLowerLoginButton();
        logInPage.fillInEmailLoginForm(user.getEmail());
        logInPage.fillInPasswordLoginForm(user.getPassword());
        logInPage.clickLoginButtonLoginPage();
        mainPage.clickUpperProfileButton();
        profilePage.checkAccountListIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Вход в аккаунт по кнопке в форме регистрации")
    public void signUpFormLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.openMainPage();
        mainPage.clickLowerLoginButton();
        logInPage.clickSignUpButtonOnLoginPage();
        signUpPage.clickLoginButton();
        logInPage.fillInEmailLoginForm(user.getEmail());
        logInPage.fillInPasswordLoginForm(user.getPassword());
        logInPage.clickLoginButtonLoginPage();
        mainPage.clickUpperProfileButton();
        profilePage.checkAccountListIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Вход в аккаунт по кнопке в форме восстановления пароля")
    public void forgotPasswordButtonLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        mainPage.openMainPage();
        mainPage.clickLowerLoginButton();
        logInPage.clickForgotPasswordButton();
        forgotPasswordPage.fillInEmail(user.getEmail());
        forgotPasswordPage.clickRecoverPasswordButton();
        resetPasswordPage.checkResetPasswordFormIsDisplayed();
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
