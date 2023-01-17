package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;

public class SaveProgramDD_SD {
	
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int progID;
	public static RequestSpecification request;
	

@Given("User get the Base Url for Progam using json File")
public void user_get_the_base_url_for_progam_using_json_file() {
	logger.info("Use get the Base URI");
	RestAssured.baseURI =baseurl;
}

@When("User Request body with json file for Progam using json File")
public void user_request_body_with_json_file_for_progam_using_json_file() {
	logger.info("Request the Body with json file Data");
	 File jsonbody = new File(".\\src\\test\\resources\\TestData\\PostData.json");
	   request = RestAssured.given();
	   request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(jsonbody);
}

@Then("Make a Post request for Progam using json File")
public void make_a_post_request_for_progam_using_json_file() {
	logger.info("User make a Post request");
	response= request.when().post("/saveprogram");
	response.prettyPrint();
}

@When("validate the status code for Progam using json File")
public void validate_the_status_code_for_progam_using_json_file() {
	logger.info("validate the status code");
	System.out.println(response.getStatusCode());
	assertEquals(response.getStatusCode(),201);
}

@Then("Save the programID for Progam using json File")
public void save_the_program_id_for_progam_using_json_file() {
	logger.info("User save the programID");
	 progID =response.jsonPath().get("programId");
	 logger.info("id = "+ progID);
	System.out.println("id = "+ progID);
}

@When("make a Get request by programId for Progam using json File")
public void make_a_get_request_by_program_id_for_progam_using_json_file() {
	logger.info("User make a Get request by programID");
	response= request.when().get("/programs/"+progID);
}

@Then("Validate the get status code for Progam using json File")
public void validate_the_get_status_code_for_progam_using_json_file() {
	System.out.println(response.getStatusCode());
	request.then().statusCode(200);
}

@Given("User get the Base Url for delete for Progam using json File")
public void user_get_the_base_url_for_delete_for_progam_using_json_file() {
	logger.info("Use get the Base URI");
	RestAssured.baseURI =baseurl;
}

@When("Make a Delete request for Progam using json File")
public void make_a_delete_request_for_progam_using_json_file() {
	logger.info("User make a delete request by programID");
	request = RestAssured.given();
	response= request.when().delete("/deletebyprogid/"+progID);
	response.prettyPrint();
}

@Then("validate the delete status code for Progam using json File")
public void validate_the_delete_status_code_for_progam_using_json_file() {
	logger.info("validate the delete status code");
	System.out.println(response.getStatusCode());
	assertEquals(response.getStatusCode(),200);
}
}
