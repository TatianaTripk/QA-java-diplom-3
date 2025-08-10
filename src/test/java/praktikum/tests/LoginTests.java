package praktikum.tests;

import io.restassured.response.ValidatableResponse;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.model.User;
import praktikum.pages.*;
import praktikum.steps.UserSteps;

public class LoginTests {
    public WebDriver driver;
    private Faker faker = new Faker();
    private boolean isUserCreated = false;
    private User user = new User();
    private UserSteps userSteps = new UserSteps();

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void upperProfileButtonLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        user.setName(faker.name().firstName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(6, 10, true, false, false));

        mainPage.openMainPage();
        mainPage.clickLowerLoginButton();
        logInPage.clickSignUpButtonOnLoginPage();
        signUpPage.fillInNameSignupForm(user.getName());
        signUpPage.fillInEmailSignupForm(user.getEmail());
        signUpPage.fillInPasswordSignUpForm(user.getPassword());
        signUpPage.clickSignUpButtonOnSignupPage();
        logInPage.checkIfLoginFormIsDisplayed();
        isUserCreated = true;
        System.out.println("Created user: " + user.getEmail() + " / " + user.getPassword());
        mainPage.clickUpperProfileButton();

        logInPage.fillInEmailLoginForm(user.getEmail());
        logInPage.fillInPasswordLoginForm(user.getPassword());
        logInPage.clickLoginButtonLoginPage();
       mainPage.clickUpperProfileButton();
       profilePage.checkIfAccountlistIsDisplayed();
           }

    @Test
    public void lowerLoginButtonLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
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

        mainPage.clickLowerLoginButton();
        logInPage.fillInEmailLoginForm(user.getEmail());
        logInPage.fillInPasswordLoginForm(user.getPassword());
        logInPage.clickLoginButtonLoginPage();
        mainPage.clickUpperProfileButton();
        profilePage.checkIfAccountlistIsDisplayed();
    }

    @Test
    public void signUpFormLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

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

        mainPage.clickLowerLoginButton();
        logInPage.clickSignUpButtonOnLoginPage();
        signUpPage.clickLoginButton();
        logInPage.fillInEmailLoginForm(user.getEmail());
        logInPage.fillInPasswordLoginForm(user.getPassword());
        logInPage.clickLoginButtonLoginPage();
        mainPage.clickUpperProfileButton();
        profilePage.checkIfAccountlistIsDisplayed();
    }

    @Test
    public void forgotPasswordButtonLoginTest() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
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

        mainPage.clickLowerLoginButton();
        logInPage.clickForgotPasswordButton();
        forgotPasswordPage.fillInEmail();
        forgotPasswordPage.clickRecoverPasswordButton();
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
