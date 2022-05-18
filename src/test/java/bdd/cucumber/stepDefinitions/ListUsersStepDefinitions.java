package bdd.cucumber.stepDefinitions;

import bdd.cucumber.pojo.ListUsers.ListAllUsers;
import bdd.cucumber.resources.APIResources;
import bdd.cucumber.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;


import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ListUsersStepDefinitions extends Utils {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Given("User has the ListUsersAPI payload")
    public void user_has_the_list_users_api_payload() throws IOException {

        requestSpecification = given().spec(GetRequestSpecification());

    }
    @When("User makes a GET call")
    public void user_makes_a_get_call() {

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();

        APIResources apiResources = APIResources.valueOf("ListUsers");

        ListAllUsers listAllUsers = requestSpecification.when().get(apiResources.getResource()).as(ListAllUsers.class);


    }
    @Then("User receives the response with {int} as response code")
    public void user_receives_the_response_with_as_response_code(Integer int1) {
        System.out.println(responseSpecification.expect().statusCode(300));
    }
    @Then("User validates the response data")
    public void user_validates_the_response_data() {

    }
    @Then("User validates the JSON schema")
    public void user_validates_the_json_schema() {

    }
    @Then("User validates the response time")
    public void user_validates_the_response_time() {

    }
}
