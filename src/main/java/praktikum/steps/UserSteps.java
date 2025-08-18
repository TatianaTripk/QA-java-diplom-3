package praktikum.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import praktikum.model.User;
import praktikum.util.RestConfig;

import static io.restassured.RestAssured.given;

public class UserSteps {

    @Step("Регистрация пользователя")
    public ValidatableResponse signupUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(RestConfig.BASE_URL)
                .body(user)
                .when()
                .post(RestConfig.CREATE_USER)
                .then();

    }

    @Step("Авторизация пользователя")
    public ValidatableResponse loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(RestConfig.BASE_URL)
                .body(user)
                .when()
                .post(RestConfig.LOGIN_USER_ENDPOINT)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(RestConfig.BASE_URL)
                .header("Authorization", "Bearer " + user.getToken())
                .when()
                .delete(RestConfig.DELETE_USER)
                .then();
    }

}

