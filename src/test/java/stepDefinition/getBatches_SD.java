package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;

public class getBatches_SD {
	public static String baseurl="https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static RequestSpecification request; 
	
	
	@Given("A service with URL for Batches")
	public void a_service_with_url_for_batches() {
		logger.info("get the base url");
		RestAssured.baseURI=baseurl;
	}

	@When("Set request header for Batches")
	public void set_request_header_for_batches() {
		logger.info("get the request header");
		request=RestAssured.given();
	}

	@When("Get request is made for Batches")
	public void get_request_is_made_for_batches() {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/batches");
	}

	@Then("Validate status code for Batches")
	public void validate_status_code_for_batches() {
		logger.info("Status code" +response.statusCode());
		Assert.assertEquals(200,response.getStatusCode());
		response.prettyPrint();
	}

	@Then("Validate batchId,batchName,batchDescription,batchStatus,batchNoOfClasses,programId,programName")
	public void validate_batch_id_batch_name_batch_description_batch_status_batch_no_of_classes_program_id_program_name() {
		logger.info("Batch ID " +response.jsonPath().get("batchId[0]"));
		logger.info("Batch Name " +response.jsonPath().get("batchName[0]"));
		logger.info("Batch Description " +response.jsonPath().get("batchDescription[0]"));
		logger.info("Batch Status " +response.jsonPath().get("batchStatus[0]"));
		logger.info("Batch NoOfClasses " +response.jsonPath().get("batchNoOfClasses[0]"));
		logger.info("Program Id " +response.jsonPath().get("programId[0]"));
		logger.info("Program Name " +response.jsonPath().get("programName[0]"));
	}

	@Given("A GET service with URL for Batches")
	public void a_get_service_with_url_for_batches() {
		
		logger.info("get the base url");
		RestAssured.baseURI=baseurl;
	}

	@When("Get request header for Batches")
	public void get_request_header_for_batches() {
		
		logger.info("get the request header");
		request=RestAssured.given();
	}
	
	@When("Get request is made to get Batch by Id as {int}")
	public void get_request_is_made_to_get_batch_by_id_as(Integer int1) {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/batches/batchId/"+int1);
	}
	

	@Then("Validate status code for Batch By Id")
	public void validate_status_code_for_batch_by_id() {
		logger.info("Status code" +response.statusCode());
		Assert.assertEquals(200,response.getStatusCode());
		response.prettyPrint();
	}
	
	@Then("Validate Batch Id as {int}")
	public void validate_batch_id_as(Integer int1) {
	int getbatchId = response.jsonPath().get("batchId");
	logger.info("Batch ID" +response.jsonPath().get("batchId"));
	Assert.assertEquals(getbatchId,int1);
	}
	

	@Given("A GET service with URL for Batches by Name")
	public void a_get_service_with_url_for_batches_by_name() {
		logger.info("get the base url");
		RestAssured.baseURI=baseurl;
	}

	@When("Get request header for Batches by Name")
	public void get_request_header_for_batches_by_name() {
		logger.info("get the request header");
		request=RestAssured.given();
	}

	@When("Get request is made to get Batch by Name as {string}")
	public void get_request_is_made_to_get_batch_by_name_as(String batchName) {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/batches/batchName/"+batchName);
	}
	

	@Then("Validate status code for Batch By Name")
	public void validate_status_code_for_batch_by_name() {
		logger.info("Status code" +response.statusCode());
		Assert.assertEquals(200,response.getStatusCode());
		response.prettyPrint();
	}

	@Then("Validate Batch Name as {string}")
	public void validate_batch_name_as(String BatchName) {
		logger.info("Batch Name" +response.jsonPath().get("batchName"));
		//String getBatchName = response.jsonPath().get("batchName");
		//logger.info("Batch Name" +response.jsonPath().get("batchName"));
		//Assert.assertEquals(getBatchName,BatchName);
	}

	@Given("A GET service with URL for Batches By ProgramId")
	public void a_get_service_with_url_for_batches_by_program_id() {
		
		logger.info("get the base url");
		RestAssured.baseURI=baseurl;
	}

	@When("Get request header for Batches ProgramId")
	public void get_request_header_for_batches_program_id() {
		
		logger.info("get the request header");
		request=RestAssured.given();
	}
	@When("Get request is made to get Batch by ProgramId as {int}")
	public void get_request_is_made_to_get_batch_by_program_id_as(Integer int2) {
		
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/batches/program/"+int2);
	}
	@When("Get request is made to get Batch by ProgramId")
	public void get_request_is_made_to_get_batch_by_program_id() {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/batches/program/493");
	}

	@Then("Validate status code for Batch By ProgramId")
	public void validate_status_code_for_batch_by_program_id() {
		
		logger.info("Status code" +response.statusCode());
		Assert.assertEquals(200,response.getStatusCode());
		response.prettyPrint();
	}
	@Then("Validate  ProgramId as {int}")
	public void validate_program_id_as(Integer int2) {
		logger.info("Program Id" +response.jsonPath().get("programId"));
		//int getprogramId = response.jsonPath().get("programId");
		//logger.info("Program Id" +response.jsonPath().get("programId"));
		//Assert.assertEquals(getprogramId,int2);
	}

	

}
