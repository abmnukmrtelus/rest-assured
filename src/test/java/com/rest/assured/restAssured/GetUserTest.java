package com.rest.assured.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void getAllUsers() {
        when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void getUserById() {
        when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .using().defaultParser(Parser.JSON)
                .body("id", equalTo(1));
    }





}
