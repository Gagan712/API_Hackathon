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

public class DeleteBatchValid_SD {
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int batchID;
	public static RequestSpecification request;
	
	
	@Given("User get the Base Url For Delete Batch Validation")
	public void user_get_the_base_url_for_delete_batch_validation() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Put the data in map For Delete Batch Validation")
	public void user_put_the_data_in_map_for_delete_batch_validation() {
		logger.info("Put all the data for batch body");
		map.put("batchName", " Jan23-API Coders-SDET-SDET85-01785");
		map.put("batchDescription", "Learn PostMan in 7 days");
		map.put("batchStatus", "Inactive");
		map.put("batchNoOfClasses", 20);
		map.put("programId", 634);
		map.put("programName", "PostMan ");
	}

	@Then("Request body with given data For Delete Batch Validation")
	public void request_body_with_given_data_for_delete_batch_validation() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(newBody.toJSONString());
	}

	@When("Make a Post request For Delete Batch Validation")
	public void make_a_post_request_for_delete_batch_validation() {
		logger.info("User make a Post request");
		response= request.when().post("/batches");
		response.prettyPrint();
	}

	@Then("Save the batchID For Delete  Batch Validation")
	public void save_the_batch_id_for_delete_batch_validation() {
		logger.info("User save the batchID");
		 batchID =response.jsonPath().get("batchId");
		logger.info("id ="+ batchID);
		System.out.println("id ="+  batchID);
	}

	@Then("validate the status code For Delete Batch Validation")
	public void validate_the_status_code_for_delete_batch_validation() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	}

	@Given("User Get Base Url for DELETE Batch By Id")
	public void user_get_base_url_for_delete_batch_by_id() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Set a request header for Delete Batch Request")
	public void user_set_a_request_header_for_delete_batch_request() {
		request=RestAssured.given();
	}

	@When("User Send a DELETE Request By Batch Id")
	public void user_send_a_delete_request_by_batch_id() {
		logger.info("User make a delete request by batchID");
		request = RestAssured.given();
		response= request.when().delete("/batches/"+batchID);
	}

	@Then("User receive Valid GET status code for Delete Batch")
	public void user_receive_valid_get_status_code_for_delete_batch() {
		logger.info("validate the delete status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);
	}

	@When("User Send a GET Request By BatchID")
	public void user_send_a_get_request_by_batch_id() {
		logger.info("User make a Get request by batchId");
		response= request.when().get("/batches/batchId/"+batchID);
	}

	@When("Program should not get fetched By BatchID")
	public void program_should_not_get_fetched_by_batch_id() {
		logger.info("Status code of GET Request "+response.statusCode());
		assertEquals( response.getStatusCode(),400);
	}

}
