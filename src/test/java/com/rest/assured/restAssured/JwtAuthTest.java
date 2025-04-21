package com.rest.assured.restAssured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JwtAuthTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dummyjson.com";
    }


    public String getJWTToken() {
        Response response = given()
                .contentType("application/json")
                .body("{ \"username\": \"emilys\", \"password\": \"emilyspass\" }")
                .when()
                .post("/auth/login");


        return response.jsonPath().getString("accessToken"); // Adjust based on your actual response structure
    }

    @Test
    public void testProtectedEndpointWithJWT() {
        String token = getJWTToken();

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/me")
                .then()
                .statusCode(200)
                .body("username", equalTo("emilys")); // Example response check
    }

}
