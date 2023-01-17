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

public class PostBatchValid_SD {
	
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int batchID;
	public static String batchName;
	public static RequestSpecification request;
	public static String postBody ;
	
	@Given("User Get the base Url for Batch")
	public void user_get_the_base_url_for_batch() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}
	
	@When("User Put the data in map for Post validation")
	public void user_put_the_data_in_map_for_post_validation() {
		logger.info("Put all the data");
		  // map.put("batchId",8796);
		    map.put("batchName","API Coders");
	        map.put("batchDescription", "Learn API Actively");
	        map.put("batchStatus", "Active");
	        map.put("batchNoOfClasses", 30);
	        map.put("programId",201);
	        map.put("programName", "BootCamp");
	}

	@Then("Request body with given data for Post validation")
	public void request_body_with_given_data_for_post_validation() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		request = RestAssured.given();
		request.header("Content-Type","Application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(newBody.toJSONString());
	}

	@When("Make a Post request for Post validation")
	public void make_a_post_request_for_post_validation() {
		logger.info("User make a Post request");
		response= request.when().post("/batches");
		response.prettyPrint();
	}

	@Then("validate the status code for Post validation")
	public void validate_the_status_code_for_post_validation() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	}

	@Then("Save the batchName for Batch for Post validation")
	public void save_the_batch_name_for_batch_for_post_validation() {
		logger.info("User save the batchName");
		 batchName =response.jsonPath().get("batchName");
		logger.info("id ="+ batchName);
		System.out.println("id ="+  batchName);
	}

	@Then("Save the batchID for Batch for Post validation")
	public void save_the_batch_id_for_batch_for_post_validation() {
		logger.info("User save the batchID");
		 batchID =response.jsonPath().get("batchId");
		logger.info("id ="+ batchID);
		System.out.println("id ="+  batchID);
	}

	@When("User set the request header for Batch")
	public void user_set_the_request_header_for_batch() {
		request = RestAssured.given();
	}

	@Then("User Put the invalid body data for Batch")
	public void user_put_the_invalid_body_data_for_batch() {
		
		logger.info("Put invalid data");
		postBody ="{\r\n"
	    		+ "        \"batchDescription\": \"python\",\r\n"
	    		+ "        \"batchStatus\": \"Active\",\r\n"
	    		+ "    }";
		request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(postBody);
	}

	@When("User make the Post request with invalid body for Batch")
	public void user_make_the_post_request_with_invalid_body_for_batch() {
		logger.info("User make a Post request");
		response= request.when().post("/batches");
		response.prettyPrint();
	}

	@Then("User validate the Status code for Batch")
	public void user_validate_the_status_code_for_batch() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),400);
	}

	@Then("User Put the no body data for Batch")
	public void user_put_the_no_body_data_for_batch() {
		logger.info("Put invalid data");
		postBody =" ";
		request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(postBody);
	}

	@When("User make the Post request with no body for Batch")
	public void user_make_the_post_request_with_no_body_for_batch() {
		logger.info("User make a Post request");
		response= request.when().post("/batches");
		response.prettyPrint();
	}

	@Then("User Put the body data with existing BatchName")
	public void user_put_the_body_data_with_existing_batch_name() {
		    map.put("batchName",batchName);
	        map.put("batchDescription", "Learn API Automation in 7 days");
	        map.put("batchStatus", "Active");
	        map.put("batchNoOfClasses", 30);
	        map.put("programId",307);
	        map.put("programName", "BootCamp");
	}
	
	@When("User make the Post request with existing BatchName")
	public void user_make_the_post_request_with_existing_batch_name() {
		logger.info("Request the Body with existing progamID");
		JSONObject newBody2 = new JSONObject(map);
		request = RestAssured.given();
		request.header("Content-Type","Application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(newBody2.toJSONString());
		response= request.when().post("/batches");
		response.prettyPrint();
	}


	@When("Make a Delete request for Post validation")
	public void make_a_delete_request_for_post_validation() {
		logger.info("User make a delete request by batchID");
		request = RestAssured.given();
		response= request.when().delete("/batches/"+batchID);
	}

	@Then("validate the delete status code for Post validation")
	public void validate_the_delete_status_code_for_post_validation() {
		logger.info("validate the delete status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);
	}



}
