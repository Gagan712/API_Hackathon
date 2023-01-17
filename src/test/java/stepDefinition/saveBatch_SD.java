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

public class saveBatch_SD {
	
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int batchID;
	public static RequestSpecification request;

	
	@Given("User get the Base Url for Batch")
	public void user_get_the_base_url_for_batch() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User Put the {string},{string},{string},{string},{string},{string}")
	public void user_put_the(String batchName, String batchDes, String batchStatus, String batchClass, String programID, String programName) {
		logger.info("Put all the data for batch body");
		map.put("batchName", batchName);
		map.put("batchDescription", batchDes);
		map.put("batchStatus", batchStatus);
		map.put("batchNoOfClasses", batchClass);
		map.put("programId", programID);
		map.put("programName", programName);
	}

	@Then("Request body with given data for Batch")
	public void request_body_with_given_data_for_batch() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(newBody.toJSONString());
	}

	@When("Make a Post request for Batch")
	public void make_a_post_request_for_batch() {
		logger.info("User make a Post request");
		response= request.when().post("/batches");
	}

	@When("Save the batchID for Batch")
	public void save_the_batch_id_for_batch() {
		logger.info("User save the batchID");
		 batchID =response.jsonPath().get("batchId");
		 logger.info("id = "+ batchID);
		System.out.println("id = "+ batchID);
	}

	@Then("validate the status code for Batch")
	public void validate_the_status_code_for_batch() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),201);
	}

	@Then("validate {string},{string},{string},{string},{string},{string}")
	public void validate(String btchName, String btchDes, String btchStatus, String btchClass, String progID, String progName) {
		
		logger.info("validate the Batch Name ");
	    String BatchName = response.jsonPath().get("batchName");
	    logger.info("Batch Name is "+BatchName );
	    assertEquals(BatchName,btchName);
	    System.out.println("Batch Name is "+BatchName);
	    
	    logger.info("validate the Batch Description");
	    String BatchDes = response.jsonPath().get("batchDescription");
	    logger.info("Description is "+BatchDes);
	    assertEquals(BatchDes,btchDes);
	    System.out.println("Description is "+btchDes);
	    
	    logger.info("validate the Batch status");
	    String batchS = response.jsonPath().get("batchStatus");
	    logger.info("Batch status is "+batchS);
	    assertEquals(batchS,btchStatus);
	    System.out.println("Batch status is "+batchS);
	       
	    logger.info("validate the Batch No Of Classes");
	    int BatchClass = response.jsonPath().get("batchNoOfClasses");
	    logger.info("No of Batch Classes "+BatchClass );
	  //  assertEquals(btchClass,BatchClass);
	    System.out.println("No of Batch classes "+BatchClass);
	    
	    logger.info("validate the Program ID");
	    int ProgID = response.jsonPath().get("programId");
	    logger.info("Program ID is "+ProgID );
	   // assertEquals(progID,ProgID);
	    System.out.println("Program ID is "+ProgID);
		
		logger.info("validate the Program Name");
	    String ProgN = response.jsonPath().get("programName");
	    logger.info("Program ID is "+ProgN );
	   // assertEquals(ProgN,progName);
	    System.out.println("Program ID is "+ProgN);
	    
	    
	    
	}

	@When("make a Get request by batchID for Batch")
	public void make_a_get_request_by_batch_id_for_batch() {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/batches/batchId/"+batchID);
	}

	@When("Validate the get status code for Batch")
	public void validate_the_get_status_code_for_batch() {
		System.out.println(response.getStatusCode());
		request.then().statusCode(200);
	}

}
