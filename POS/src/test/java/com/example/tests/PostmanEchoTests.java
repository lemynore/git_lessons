package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTests {

    private final String baseUrl = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        Response response = given()
                .when()
                .get(baseUrl + "/get")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is a raw text request";

        Response response = given()
                .body(requestBody)
                .when()
                .post(baseUrl + "/post")
                .then()
                .statusCode(200)
                .extract().response();

        response.then().body("data", equalTo(requestBody));
        System.out.println(response.asString());
    }

    @Test
    public void testPostFormData() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded") // Установка заголовка Content-Type
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(baseUrl + "/post");


        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());

        // Проверка статуса
        if (response.getStatusCode() == 200) {
            // Проверка тела ответа
            response.then().body("form.foo1", equalTo("bar1"));
            response.then().body("form.foo2", equalTo("bar2"));
        } else {
            System.err.println("Error: " + response.getStatusCode() + " - " + response.asString());

            // Дополнительная обработка ошибок
            handleErrorResponse(response);
        }
    }

    private void handleErrorResponse(Response response) {
        int statusCode = response.getStatusCode();
        switch (statusCode) {
            case 400:
                System.err.println("Bad Request: Please check the request parameters.");
                break;
            case 401:
                System.err.println("Unauthorized: Please check your authentication.");
                break;
            case 403:
                System.err.println("Forbidden: You do not have permission to access this resource.");
                break;
            case 404:
                System.err.println("Not Found: The requested resource could not be found.");
                break;
            case 500:
                System.err.println("Internal Server Error: Please check server logs.");
                break;
            default:
                System.err.println("Unexpected error: " + response.asString());
                break;
        }
    }
    @Test
    public void testPutRequest() {
        String requestBody = "{ \"message\": \"This is a PUT request\" }";

        System.out.println("Request Body: " + requestBody);

        Response response = given()
                .body(requestBody)
                .when()
                .put(baseUrl + "/put")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());

        response.then().body("data", equalTo(requestBody));
    }
    @Test
    public void testPatchRequest() {
        String requestBody = "{ \"message\": \"This is a PATCH request\" }";

        Response response = given()
                .body(requestBody)
                .when()
                .patch(baseUrl + "/patch")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());

        response.then().body("data", equalTo(requestBody));
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .when()
                .delete(baseUrl + "/delete")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
    }
}
