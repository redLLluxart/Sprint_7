package order;

import data.OrderCreds;
import data.Orders;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient {
    public static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/";
    private static final String PATH = "api/v1/orders";

    private static final String DELETE_PATH = "api/v1/orders/cancel";
    public OrderClient() {
        RestAssured.baseURI = BASE_URI;
    }

    public ValidatableResponse create(Orders order) {

        return given()
                .spec(Specification.requestSpecification())
                .and()
                .body(order)
                .when()
                .post(PATH)
                .then();
    }
    public ValidatableResponse delete(int trackId) {

        OrderCreds orderCreds = new OrderCreds(trackId);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(orderCreds)
                .when()
                .put(DELETE_PATH)
                .then();
    }
}
