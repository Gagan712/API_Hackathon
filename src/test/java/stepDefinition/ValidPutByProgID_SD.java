package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;

public class ValidPutByProgID_SD {
	
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int progID;
	public static RequestSpecification request;
		
	@Given("User get the Base Url to create program for Put validation")
	public void user_get_the_base_url_to_create_program_for_put_validation() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Put the data in map for Put validation")
	public void user_put_the_data_in_map_for_put_validation() {
		logger.info("Put all the data for program body");
		  // map.put("programId", progID);
		   map.put("programName", "Jan23-API Coders-6543");
		   map.put("programDescription", "Learn Put Request Validation");
		   map.put("programStatus", "Active");
		   map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		   map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	}

	@Then("Request body with given data for Put validation")
	public void request_body_with_given_data_for_put_validation() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(newBody.toJSONString());
	}

	@When("Make a Post request for Progam by ProgramID for Put validation")
	public void make_a_post_request_for_progam_by_program_id_for_put_validation() {
		logger.info("User make a Post request");
		response= request.when().post("/saveprogram");
		response.prettyPrint();
	}

	@Then("Save the programID for Progam by ProgramID for Put validation")
	public void save_the_program_id_for_progam_by_program_id_for_put_validation() {
		logger.info("User save the programID");
		 progID =response.jsonPath().get("programId");
		 logger.info("id = "+ progID);
		System.out.println("id = "+ progID);
	}

	@Then("validate the status code for Progam by ProgramID for Put validation")
	public void validate_the_status_code_for_progam_by_program_id_for_put_validation() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	}

	@When("make a Get request by programId for Put validation")
	public void make_a_get_request_by_program_id_for_put_validation() {
		logger.info("User make a Get request by programID");
		 request = RestAssured.given();
		response= request.when().get("/programs/"+progID);
	}

	@Then("Validate the get status code for Put validation")
	public void validate_the_get_status_code_for_put_validation() {
		System.out.println(response.getStatusCode());
		request.then().statusCode(200);
	}

	@Given("User get the Base URL for Put validation")
	public void user_get_the_base_url_for_put_validation() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("Set Update Request with invalid Body for Put validation")
	public void set_update_request_with_invalid_body_for_put_validation() {
		logger.info("Put all the data for program body");
		  // map.put("programId", progID);
		   map.put("programName","Jan23-API Coders-0171" );
		   map.put("programDescription", "Learn API in 10 days");
		  // map.put("programStatus", "Active");
		  //map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		  // map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	}

	@When("Make a Put request for Put validation")
	public void make_a_put_request_for_put_validation() {
		logger.info("User make a update request with invalid body by programID");
		JSONObject updateBody1 = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(updateBody1.toJSONString());
	        response= request.when().put("/putprogram/"+progID);
	        response.prettyPrint();
	}

	@Then("validate the put status code for Put validation")
	public void validate_the_put_status_code_for_put_validation() {
		logger.info("validate the put status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		//assertEquals(response.getStatusCode(),400);
	}

	@When("Make a Put request with no Body for Put validation")
	public void make_a_put_request_with_no_body_for_put_validation() {
		logger.info("User make a update request with no body by programID");
		 response= request.when().put("/putprogram/"+progID);
	        response.prettyPrint();
	}

	@Given("User get the Base Url for delete for Put validation")
	public void user_get_the_base_url_for_delete_for_put_validation() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("Make a Delete request for Put validation")
	public void make_a_delete_request_for_put_validation() {
		logger.info("User make a delete request by programID");
		request = RestAssured.given();
		response= request.when().delete("/deletebyprogid/"+progID);
		response.prettyPrint();
	}

	@Then("validate the delete status code for Put validation")
	public void validate_the_delete_status_code_for_put_validation() {
		logger.info("validate the delete status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);
	}


}
