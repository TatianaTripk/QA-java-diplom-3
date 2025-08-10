package praktikum.tests;

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
    private WebDriver driver;
    private Faker faker = new Faker();
    private boolean isUserCreated = false;
    private User user = new User();
    private UserSteps userSteps = new UserSteps();

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
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
        logInPage.checkIfLoginFormIsDisplayed();
        isUserCreated = true;
    }

    @Test
    public void invalidPasswordSignupTest() {
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
        signUpPage.fillInInvalidPasswordSignUpForm();
        signUpPage.clickSignUpButtonOnSignupPage();
        signUpPage.checkIfPasswordErrorIsDisplayed();
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
