package courier;

import data.Courier;
import data.CourierCreds;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient {

    public static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/";
    private static final String PATH = "api/v1/courier";
    private static final String LOGIN_PATH = "api/v1/courier/login";
    private static final String DELETE_PATH = "api/v1/courier/";

    public CourierClient() {
        RestAssured.baseURI = BASE_URI;
    }

    public ValidatableResponse create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(PATH)
                .then();
    }

    public ValidatableResponse login(CourierCreds creds) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    public ValidatableResponse delete(int Id) {
        return given()
                .header("Content-type", "application/json")
                .delete(DELETE_PATH + Id)
                .then();
    }
}
