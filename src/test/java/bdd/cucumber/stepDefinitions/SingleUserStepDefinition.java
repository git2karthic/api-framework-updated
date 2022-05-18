package bdd.cucumber.stepDefinitions;

import bdd.cucumber.resources.APIResources;
import bdd.cucumber.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SingleUserStepDefinition extends Utils {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;


    @Given("User is provided with SingleUser payload")
    public void user_is_provided_with_single_user_payload() throws IOException {
        requestSpecification = given().spec(GetRequestSpecification());
    }
    @When("User makes a API call with id as {int}")
    public void user_makes_a_api_call_with_id_as(Integer int1) {

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        APIResources apiResources = APIResources.valueOf("SingleUser");

        response = requestSpecification.when().get(apiResources.getResource() + int1);
        System.out.println(GetJsonPath(response, "data.id"));

    }
    @Then("User receives the response response code as {int}")
    public void user_receives_the_response_response_code_as(Integer int1) {

    }
    @Then("User validates the received response data")
    public void user_validates_the_received_response_data() {

    }
    @Then("User performs the JSON schema validation")
    public void user_performs_the_json_schema_validation() {
        File schema = new File(System.getProperty("user.dir")+"/src/test/java/bdd/cucumber/jsonSchema/SingleUser.json");
        APIResources apiResources = APIResources.valueOf("SingleUser");
        requestSpecification
                .when()
                .get(apiResources.getResource() + "2")
                .then()
                .body(matchesJsonSchema(schema));
        System.out.println("Hello world");
    }
    @Then("User validates the response time of the response")
    public void user_validates_the_response_time_of_the_response() {

    }

}
