package com.rest.assured.restAssured;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchUserTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void patchUser() {
        String updatedEmail = "{ \"email\": \"patched@example.com\" }";

        given()
                .contentType(ContentType.JSON)
                .body(updatedEmail)
                .when()
                .patch("/users/1")
                .then()
                .statusCode(200)
                .body("email", equalTo("patched@example.com"));
    }
}
