package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_Program_SD {
	
	public static String baseurl="https://lms-backend-service.herokuapp.com/lms";
	
	public static RequestSpecification request;
	public static Response updatebyname;
	
	public static String jsonString = "{\r\n"
			+ "    \"programId\": 1539,\r\n"
			+ "    \"programName\": \"Cloud9\",\r\n"
			+ "    \"programDescription\": \"Learn Cloud\",\r\n"
			+ "    \"programStatus\": \"Active\",\r\n"
			+ "    \"creationTime\": \"2022-09-28T19:53:25.244+00:00\",\r\n"
			+ "    \"lastModTime\": \"2022-09-28T19:53:25.244+00:00\"\r\n"
			+ "}";
	

@Given("Set PUT program by programName endpoint")
public void set_put_program_by_program_name_endpoint() {
	RestAssured.baseURI = baseurl;
	
		   
}

@When("Set Update Request Body")
public void set_update_request_body() {
	
	request =RestAssured.given();
	request.header("Content-Type","application/json");
    
}

@When("Send HTTP request")
public void send_http_request() {
	
	
	 updatebyname = request.body(jsonString).put("program/Cloud9");	

}

@Then("Validate response code")
public void validate_response_code() {
	Assert.assertEquals(updatebyname.getStatusCode(),200);
	updatebyname.prettyPrint();
}


}
