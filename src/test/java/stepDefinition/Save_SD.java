package stepDefinition;

//import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import java.util.HashMap;
//import java.util.Map;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class Save_SD {
	public static HashMap<String,Object> map =new HashMap<String,Object>();

@Given("User get the Base Url as {string}")
public void user_get_the_base_url_as(String string) {
	baseURI = "https://lms-backend-service.herokuapp.com/lms";
}

@When("User Put the {string},{string},{string},{string},{string} in Json")
public void user_put_the_in_json(String ProgramName, String ProgramDES, String ProgStatus, String creationTime, String LastModTime) {
	 map.put("programName", ProgramName);
	   map.put("programDescription", ProgramDES);
	   map.put("programStatus", ProgStatus);
	   map.put("creationTime",creationTime );
	   map.put("lastModTime", LastModTime);
	   JSONObject request = new JSONObject(map);
	   given()
	     .header("Content-Type","application/json")
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(request.toJSONString())
		 .when()
		 .post("/saveprogram")
		 .then()
		 .statusCode(201);
}

@Then("Request body with given data")
public void request_body_with_given_data() {
	 
}

@When("Make a Post request")
public void make_a_post_request() {
	
}

@Then("validate the status code")
public void validate_the_status_code() {
   
}



}
