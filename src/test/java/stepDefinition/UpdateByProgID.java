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

public class UpdateByProgID {
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int progID;
	public static RequestSpecification request;
	
	
	@Given("User get the Base Url for Progam by ProgramID")
	public void user_get_the_base_url_for_progam_by_program_id() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Put the data in map for Progam by ProgramID")
	public void user_put_the_data_in_map_for_progam_by_program_id() {
		logger.info("Put all the data for program body");
		  // map.put("programId", progID);
		   map.put("programName", "Jan23-API Coders-0178");
		   map.put("programDescription", "Learn API in 7 days");
		   map.put("programStatus", "Active");
		   map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		   map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	}

	@Then("Request body with given data for Progam by ProgramID")
	public void request_body_with_given_data_for_progam_by_program_id() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(newBody.toJSONString());
	}

	@When("Make a Post request for Progam by ProgramID")
	public void make_a_post_request_for_progam_by_program_id() {
		logger.info("User make a Post request");
		response= request.when().post("/saveprogram");
		response.prettyPrint();
	}

	@Then("Save the programID for Progam by ProgramID")
	public void save_the_program_id_for_progam_by_program_id() {
		logger.info("User save the programID");
		 progID =response.jsonPath().get("programId");
		 logger.info("id = "+ progID);
		System.out.println("id = "+ progID);
	}

	@Then("validate the status code for Progam by ProgramID")
	public void validate_the_status_code_for_progam_by_program_id() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	}

	@When("make a Get request by programId for Progam by ProgramID")
	public void make_a_get_request_by_program_id_for_progam_by_program_id() {
		logger.info("User make a Get request by programID");
		response= request.when().get("/programs/"+progID);
	}

	@Then("Validate the get status code for Progam by ProgramID")
	public void validate_the_get_status_code_for_progam_by_program_id() {
		System.out.println(response.getStatusCode());
		request.then().statusCode(200);
	}


	@When("Set Update Request Body for Progam by ProgramID")
	public void set_update_request_body_for_progam_by_program_id() {
		logger.info("Put all the data for program body");
		  map.put("programId", progID);
		   map.put("programName","Jan23-API Coders-4356" );
		   map.put("programDescription", "Learn API in 10 days");
		  map.put("programStatus", "Active");
		  map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		  map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	}

	@When("Make a Put request for Progam by ProgramID")
	public void make_a_put_request_for_progam_by_program_id() {
		logger.info("User make a update request by programID");
		JSONObject updateBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(updateBody.toJSONString());
	        response= request.when().put("/putprogram/"+progID);
	        response.prettyPrint();
	}

	@Then("validate the put status code for Progam by ProgramID")
	public void validate_the_put_status_code_for_progam_by_program_id() {
		logger.info("validate the put status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);
	}

	@Given("User get the Base Url for delete for Progam by ProgramID")
	public void user_get_the_base_url_for_delete_for_progam_by_program_id() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("Make a Delete request for Progam by ProgramID")
	public void make_a_delete_request_for_progam_by_program_id() {
		logger.info("User make a delete request by programID");
		request = RestAssured.given();
		response= request.when().delete("/deletebyprogid/"+progID);
		response.prettyPrint();
	}

	@Then("validate the delete status code for Progam by ProgramID")
	public void validate_the_delete_status_code_for_progam_by_program_id() {
		logger.info("validate the delete status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);

	}

}
