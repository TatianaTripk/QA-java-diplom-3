package praktikum.steps;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import praktikum.model.User;
import praktikum.pages.SignUpPage;
import praktikum.util.RestConfig;

import static io.restassured.RestAssured.given;

public class UserSteps {

        public ValidatableResponse signupUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(RestConfig.BASE_URL)
                .body(user)
                .when()
                .post(RestConfig.CREATE_USER)
                .then();

    }

    public ValidatableResponse loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(RestConfig.BASE_URL)
                .body(user)
                .when()
                .post(RestConfig.LOGIN_USER_ENDPOINT)
                .then();
    }

    public ValidatableResponse deleteUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri("https://stellarburgers.nomoreparties.site")
                .header("Authorization", "Bearer " + user.getToken())
                .when()
                .delete(RestConfig.DELETE_USER)
                .then();
    }

}

