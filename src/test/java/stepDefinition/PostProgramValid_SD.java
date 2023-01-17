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

public class PostProgramValid_SD {
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	//public static int progID;
	public static RequestSpecification request;
	public static String postBody ;
	
	@Given("Use Get the base Url")
	public void use_get_the_base_url() {
		logger.info("Use get the Base URI");
		RestAssured.baseURI =baseurl;
	}

	@When("User set the request header")
	public void user_set_the_request_header() {
		request = RestAssured.given();
	}

	@Then("User Put the invalid body data")
	public void user_put_the_invalid_body_data() {
		logger.info("Put invalid body data for program body");
		//map.put("programName","Jan23-API Coders-4356" );
		   map.put("programDescription", "Learn API in 10 days");
		  map.put("programStatus", "Active");
		 // map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		 // map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");
	}
	@When("User make the Post request with invalid body")
	public void user_make_the_post_request_with_invalid_body() {
		logger.info("Request the Body with Given Data");
		JSONObject newBody = new JSONObject(map);
		request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(newBody.toJSONString());
		response= request.when().post("/saveprogram");
		response.prettyPrint();
	}

	@When("User make the Post request")
	public void user_make_the_post_request() {
		logger.info("User make a Post request");
		JSONObject newBody = new JSONObject(map);
		request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(newBody.toJSONString());
		response= request.when().post("/saveprogram");
		response.prettyPrint();
	}

	@Then("User validate the Status code")
	public void user_validate_the_status_code() {
		logger.info("validate the status code");
		//logger.info(response.getStatusCode());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),400);
	}

	@Then("User Put the no body data")
	public void user_put_the_no_body_data() {
	    postBody="";
	    request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(postBody);
	}

@When("User make the Post request with no body")
public void user_make_the_post_request_with_no_body() {
	logger.info("User make a Post request");
	response= request.when().post("/saveprogram");
	response.prettyPrint();
}
	@Then("User Put the body data with existing ProgramName")
	public void user_put_the_body_data_with_existing_program_name() {
	  
		logger.info("Put body data with existing ProgramName");
		   map.put("programName","Jan23-API_LEARNERS-SDET-523008");
		   map.put("programDescription", "Learn API in 5 days");
		  map.put("programStatus", "Active");
		  map.put("creationTime", "2022-09-28T19:53:25.244+00:00");
		  map.put("lastModTime", "2022-09-28T19:53:25.244+00:00");

}
}
