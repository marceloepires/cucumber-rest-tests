package com.study.cucumberresttests.steps;

import com.study.cucumberresttests.model.Posts;
import com.study.cucumberresttests.utilities.RestAssuredExtension;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;


import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class MyStepdefs {

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Value("${base.url}")
    private String baseUrl;

    @Value("${server.port}")
    private int port;

    @Autowired
    RestAssuredExtension restAssuredExtension;

    private static ResponseOptions<Response> response;

    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws URISyntaxException {
        response = RestAssuredExtension.getOps(url);
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String authorName) {
        assertThat(response.getBody().jsonPath().get("author"), Matchers.hasItem(authorName));
    }

    @And("I should see authors names")
    public void iShouldSeeAuthorsNames() {
        BDDStyleMethod.PerformContainsCollection();
    }

    @And("I should verify GET Parameter")
    public void iShouldVerifyGETParameter() {
        BDDStyleMethod.PerformPathParameter();
    }

//    @Given("I click login in Home Page")
//    public void iClickLoginInHomePage() {
//
//        var posts = Posts.builder()
//                .id(1)
//                .title("Selenium")
//                .author("Marcelo")
//                .build();
//    }
//
//    @And("I click login button")
//    public void iClickLoginButton() {
//        var response = given()
//                .baseUri(baseUrl)
//                .port(port)
//                .basePath("/post/1/")
//                .get();
//        var responseEntity = response.body().as(Posts.class);
//    }
//
//    @Then("I should see userform page")
//    public void iShouldSeeUserformPage() {
//        assertThat(responseEntity).isEqualTo(posts);
//    }
}
