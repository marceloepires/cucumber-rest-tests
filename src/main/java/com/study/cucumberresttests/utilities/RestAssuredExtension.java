package com.study.cucumberresttests.utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Component
public class RestAssuredExtension {

    public static RequestSpecification request;

    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        request = RestAssured.given().spec(requestSpec);
    }

    public static void getOpsWithPathParameter(String url, Map<String, String> pathParams) throws URISyntaxException {
        //Act
        request.pathParams(pathParams);
        request.get(new URI(url));
    }

    public static ResponseOptions<Response> getOps(String url) throws URISyntaxException {
        //Act
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e){
          e.printStackTrace();
        }
        return null;
    }

}
