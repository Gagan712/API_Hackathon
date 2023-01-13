package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import java.util.HashMap;
//import java.util.Map;

import org.json.simple.JSONObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;

public class Save_SD {
	public static HashMap<String,Object> map =new HashMap<String,Object>();
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int progID;
	//public static String ProgDes;
	public static RequestSpecification request;

@Given("User get the Base Url as {string}")
public void user_get_the_base_url_as(String string) {
	logger.info("Use get the Base URI");
	RestAssured.baseURI =baseurl;
}

@When("User Put the {string},{string},{string},creation time,lastModtime in Json")
public void user_put_the_creation_time_last_modtime_in_json(String programName, String progDes, String progStatus) {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+00:00");
	String d =df.format(new Date()).toString();
	logger.info("Put all the data for program body");
	   map.put("programName", programName);
	   map.put("programDescription", progDes);
	   map.put("programStatus", progStatus);
	   map.put("creationTime", d);
	   map.put("lastModTime", d);
}


@Then("Request body with given data")
public void request_body_with_given_data() {
	logger.info("Request the Body with Given Data");
	JSONObject newBody = new JSONObject(map);
	   request = RestAssured.given();
	   request.header("Content-Type","Application/json")
	    .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(newBody.toJSONString());
	 
}

@When("Make a Post request")
public void make_a_post_request() {
	logger.info("User make a Post request");
	response= request.when().post("/saveprogram");
	
}
@When("Save the programID")
public void save_the_program_id() {
	logger.info("User save the programID");
	 progID =response.jsonPath().get("programId");
	System.out.println("id = "+ progID);
}

@Then("validate the status code")
public void validate_the_status_code() {
	logger.info("validate the status code");
	//logger.info(response.getStatusCode());
	System.out.println(response.getStatusCode());
	//request.then().statusCode(201);
	
}

@Then("validate {string},{string},{string}")
public void validate(String proN, String proD, String proS) {
	
	logger.info("validate the Program Name");
    String ProgN = response.jsonPath().get("programName");
    logger.info("Program Name is "+ProgN );
    assertEquals(ProgN,proN);
    System.out.println("Program Name is "+ProgN);
    
    logger.info("validate the Program Description");
    String ProgDes = response.jsonPath().get("programDescription");
    logger.info("Description is "+ProgDes);
    assertEquals(ProgDes,proD);
    System.out.println("Description is "+ProgDes);
    
    logger.info("validate the Program status");
    String ProgS = response.jsonPath().get("programStatus");
    logger.info("Program status is "+ProgS);
    assertEquals(ProgS,proS);
    System.out.println("Program status is "+ProgS);
}

@When("make a Get request by programId")
public void make_a_get_request_by_program_id() {
	logger.info("User make a Get request by programID");
	response= request.when().get("/programs/"+progID);
}
@And ("Validate the get status code")
public void validate_the_get_status_code()
{
	System.out.println(response.getStatusCode());
	//request.then().statusCode(200);
}

}
