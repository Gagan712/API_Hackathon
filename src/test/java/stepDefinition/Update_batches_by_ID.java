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

public class Update_batches_by_ID {
	
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl ="https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int batchID;
	public static RequestSpecification request;
	
	@Given("User get the Base Url for Batch by BatchID")
	public void user_get_the_base_url_for_batch_by_batch_id() {
		
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Put the data in map for Batch by BatchID")
	public void user_put_the_data_in_map_for_batch_by_batch_id() {
		logger.info("Put all the data");
		   map.put("batchId",1234);
		    map.put("batchName","SDET API");
	        map.put("batchDescription", "Learn API Actively");
	        map.put("batchStatus", "Active");
	        map.put("batchNoOfClasses", 30);
	        map.put("programId",201);
	        map.put("programName", "BootCamp");

		
	    
	}

	@Then("Request body with given data for Batch by BatchID")
	public void request_body_with_given_data_for_batch_by_batch_id() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		request = RestAssured.given();
		request.header("Content-Type","Application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(newBody.toJSONString());
	}

	@When("Make a Post request for Batch by BatchID")
	public void make_a_post_request_for_batch_by_batch_id() {
		logger.info("User make a Post request");
		response= request.when().post("/batches");
		response.prettyPrint();
	}

	@Then("Save the BatchId for Batch")
	public void save_the_batch_id_for_batch() {
		logger.info("User save the batchID");
		 batchID =response.jsonPath().get("batchId");
		logger.info("id ="+ batchID);
		System.out.println("id ="+  batchID);
	}

	@Then("validate the status code for Batch by BatchId")
	public void validate_the_status_code_for_batch_by_batch_id() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	    
	}

	@When("make a Get request by batchId for Batch by BatchID")
	public void make_a_get_request_by_batch_id_for_batch_by_batch_id() {
		logger.info("User make a Get request by batchId");
		response= request.when().get("/batches/batchId/"+batchID);
	}

	@Then("Validate the get status code for Batch by BatchID")
	public void validate_the_get_status_code_for_batch_by_batch_id() {
		System.out.println(response.getStatusCode());
		request.then().statusCode(200);
	}


	@When("Set Update Request Body for Batch by batchId")
	public void set_update_request_body_for_batch_by_batch_id() {
		logger.info("Update the Batch by Batch Id");
		 map.put("batchName","SDET API");
	        map.put("batchDescription", "Learn API Actively");
	        map.put("batchStatus", "Active");
	        map.put("batchNoOfClasses", 50);
	        map.put("programId",333);
	        map.put("programName", "BootCamp");
	}

	@When("Make a Put request for Batch by batchId")
	public void make_a_put_request_for_batch_by_batch_id() {
		
		logger.info("update the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		request = RestAssured.given();
		request.header("Content-Type","Application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(newBody.toJSONString());
		response= request.when().put("/batches/"+batchID);
	    
	}

	@Then("validate the put status code for Batch by batchId")
	public void validate_the_put_status_code_for_batch_by_batch_id() {
		logger.info("validate the put status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		//assertEquals(response.getStatusCode(),400);
	}

	@Given("User get the Base Url for delete for Batch by batchId")
	public void user_get_the_base_url_for_delete_for_batch_by_batch_id() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("Make a Delete request for Batch by batchId")
	public void make_a_delete_request_for_batch_by_batch_id() {
		logger.info("User make a delete request by programID");
		request = RestAssured.given();
		response= request.when().delete("/batches/"+batchID);
	}

	@Then("validate the delete status code for Batch by batchId")
	public void validate_the_delete_status_code_for_batch_by_batch_id() {
		logger.info("validate the delete status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);
	}


}
