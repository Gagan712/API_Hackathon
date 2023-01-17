package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;

public class DeleteValid_SD {
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int progID;
	public static RequestSpecification request;
	
	@Given("User get the Base Url For Delete Validation")
	public void user_get_the_base_url_for_delete_validation() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Put the data in map For Delete Validation")
	public void user_put_the_data_in_map_for_delete_validation() {
		logger.info("Put all the data for program body");
		  // map.put("programId", progID);
		   map.put("programName", "Jan23-API Coders-8765");
		   map.put("programDescription", "Learn Delete Validation");
		   map.put("programStatus", "Active");
		   map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		   map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	}

	@Then("Request body with given data For Delete Validation")
	public void request_body_with_given_data_for_delete_validation() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(newBody.toJSONString());
	}

	@When("Make a Post request For Delete Validation")
	public void make_a_post_request_for_delete_validation() {
		logger.info("User make a Post request");
		response= request.when().post("/saveprogram");
		response.prettyPrint();
	}

	@Then("Save the programID For Delete Validation")
	public void save_the_program_id_for_delete_validation() {
		logger.info("User save the programID");
		 progID =response.jsonPath().get("programId");
		 logger.info("id = "+ progID);
		System.out.println("id = "+ progID);
	}

	@Then("validate the status code For Delete Validation")
	public void validate_the_status_code_for_delete_validation() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	}

	@Given("User Get Base Url for DELETE Program By Id")
	public void user_get_base_url_for_delete_program_by_id() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Set a request header for Delete Request")
	public void user_set_a_request_header_for_delete_request() {
		request=RestAssured.given();
	}

	@When("User Send a DELETE Request By Program Id")
	public void user_send_a_delete_request_by_program_id() {
		logger.info("User make a delete request by programID");
		response=request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
		        .delete("/deletebyprogid/"+progID);
		response.prettyPrint();
	}

	@Then("User receive Valid GET status code")
	public void user_receive_valid_get_status_code() {
		logger.info("Status code of Delete Request "+response.statusCode());
		assertEquals( response.getStatusCode(),200);
		
	}

	@When("User Send a GET Request By ProgramId")
	public void user_send_a_get_request_by_program_id() {
		logger.info("User make a Get request by programID");
		response= request.when().get("/programs/"+progID);
		response.prettyPrint();
	}

	@But("Program should not get fetched")
	public void program_should_not_get_fetched() {
		logger.info("Status code of GET Request "+response.statusCode());
		assertEquals( response.getStatusCode(),400);
	}

}
