package com.rest.assured.restAssured;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test(description = "Given user details, when creating a user, then user should be created")
    public void createUserTest() {
        String payload = """
                {
                    "name": "John Doe",
                    "email": "john@example.com"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/users")
                .then()
                .statusCode(200)
                .body("name", equalTo("John Doe"))
                .body("email", equalTo("john@example.com"));




    }


}
