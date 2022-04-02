package com.study.cucumberresttests.steps;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

public class BDDStyleMethod {

    public static void SimpleGetPost(String postNumber){
        given().contentType(ContentType.JSON);
        when().get(String.format("http://localhost:3000/posts/"+postNumber)).
                then().body("author", Matchers.equalTo("Marcelo"));
    }

    public static void PerformContainsCollection(){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/")).
                then().body("author", containsInAnyOrder("Marcelo","Joao",null))
                .statusCode(200);
    }

    public static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON)
                .with()
                .pathParam("post",1)
                .when()
                .get("http://localhost:3000/posts/{post}")
                .then()
                .body("author",containsString("Marcelo"));
    }
}
