package com.rest.assured.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void updateUser() {
        String updatedUser = "{ \"name\": \"Jane Doe\", \"email\": \"jane@example.com\" }";

        given()
                .contentType(ContentType.JSON)
                .body(updatedUser)
                .when()
                .put("/users/1")
                .then()
                .statusCode(200)
                 .body("name", equalTo("Jane Doe"))
                .body("email", equalTo("jane@example.com"));
    }
}

