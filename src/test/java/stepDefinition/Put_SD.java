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

public class Put_SD {
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	//public static int progID;
	public static RequestSpecification request;
	
	
	
	
	@Given("User get the Base Url for Put Program")
	public void user_get_the_base_url_for_put_program() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}
	 @When ("User get all the data")
	 public void user_get_all_the_data() {
		 logger.info("Put all the data for program body");
		   map.put("programId", 2441);
		   map.put("programName", "Jan23-Cloud 3456");
		   map.put("programDescription", "Learn Cloud");
		   map.put("programStatus", "Active");
		   map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		   map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	 }
	 
	 
	@Then("Set Update Request Body for Put Program")
	public void set_update_request_body_for_put_program() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		   request = RestAssured.given();
		   request.header("Content-Type","Application/json")
		    .contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			 .body(newBody.toJSONString());
	}
	 

	@When("Make a Put request for Put Program")
	public void make_a_put_request_for_put_program() {
		logger.info("Make a Put request");
		   response= request.when().put("/putprogram/2441");
	}

	@Then("validate the put status code for Put Program")
	public void validate_the_put_status_code_for_put_program() {
		logger.info("validate the put status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),200);
	}

}
