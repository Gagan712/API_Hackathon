package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class NegativeScenariosDelete_SD{

	public static String baseurl="https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int programId;
	public static RequestSpecification request;
	public static String programName;
	public static Object pid;
	
	
	@Given("I Set DELETE Program By Id endpoint")
	public void i_set_delete_program_by_id_endpoint() {
		RestAssured.baseURI= baseurl;
	}

	
	@When("I Set a request header for Id")
	public void i_set_a_request_header_for_id() {
		request=RestAssured.given(); 
	}


	@When("Send a DELETE By Id HTTP request")
	public void send_a_delete_by_id_http_request() {
		
		
		response=request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
		        .delete("/deletebyprogid/356");
		
	}
	
	
	@Then("I recive Valid GET status code for id")
	public void i_recive_valid_get_status_code_for_id() {
		System.out.println("Status code of GET Request"+response.statusCode());
		Assert.assertEquals( response.getStatusCode(),200);
		response.prettyPrint();
	}
	
    @Given("I Set DELETE Program By Name endpoint")
	public void i_set_delete_program_by_name_endpoint() {
		
		RestAssured.baseURI= baseurl;
	    
	}
    
    @When("I Set request header for Name")
	public void i_set_request_header_for_name() {
		request=RestAssured.given(); 
	   
	}

	@When("Send a DELETE By Name HTTP request")
	public void send_a_delete_by_name_http_request() {
		
		response=request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
			    .delete("/deletebyprogname/monika Jan12-API Coders-SDET-017-111760");
	}
		
		@Then("I recive Valid GET status code for Name")
		public void i_recive_valid_get_status_code_for_name() {
			
			System.out.println("Status code of GET Request"+response.statusCode());
			Assert.assertEquals( response.getStatusCode(),200);
			response.prettyPrint();
			
			
		}
		
		
		@When("Send a GET By Id HTTP request")
		public void send_a_get_by_id_http_request() {
			response=request
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
				    .get("/programs/356");
			response.then().log().all();
		}

		@When("Program should not get fetched")
		public void program_should_not_get_fetched() {
			

			System.out.println("Status code of GET Request"+response.statusCode());
			Assert.assertEquals( response.getStatusCode(),400);
		
		}

		
		
		
}




