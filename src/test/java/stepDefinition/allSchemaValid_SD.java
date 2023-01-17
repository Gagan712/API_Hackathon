package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class allSchemaValid_SD {
	
	public static String baseurl="https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static RequestSpecification request; 

@Given("User get the Base URL for all Programs")
public void user_get_the_base_url_for_all_programs() {
	RestAssured.baseURI=baseurl;
}

@When("User make the Get all Programs")
public void user_make_the_get_all_programs() {
	request=RestAssured.given();
	response = request
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			 .get("/allPrograms");
	      

}

@Then("Get the Validate the Schema")
public void get_the_validate_the_schema() {
   response.then().
	log().ifValidationFails().
	assertThat().
	statusCode(200).
     and().
	contentType(ContentType.JSON).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("allSchema.json"));

}
}
