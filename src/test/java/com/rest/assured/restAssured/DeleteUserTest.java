package com.rest.assured.restAssured;



import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void deleteUser() {
        when()
                .delete("/users/1")
                .then()
                .statusCode(200);
    }
}
