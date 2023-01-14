package stepDefinition;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import io.cucumber.java.en.*;

public class UpdateProgramById_SD {
	public static String baseurl="https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int programId;
	public static RequestSpecification request; 
	public static String programName;
	public static int progID;

@Given("A service with URL")
public void a_service_with_url() {
	RestAssured.baseURI=baseurl;
	    
}

@When("Set request header")
public void set_request_header() {
	request=RestAssured.given();
}

@When("Get request is made with programId")
public void get_request_is_made_with_program_id() {
	response = request
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			.get("programs/1539");
			//.get("/allprograms/"+response.jsonPath().get("programId"));
			//.get("/allPrograms");
    
}
    
@When("Save the programID")
public void save_the_program_id() {
	logger.info("User save the programID");
	 progID =response.jsonPath().get("programId");
	System.out.println("id = "+ progID);
}


@When("PUT request is made")
public void put_request_is_made() {
   
	logger.info("PUT request is made");
	response=request
			.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body("{\r\n"
			+ "    \"programId\": 1539,\r\n"
			+ "    \"programName\": \"Cloud9\",\r\n"
			+ "    \"programDescription\": \"Learn CloudCompute\",\r\n"
			+ "    \"programStatus\": \"Active\",\r\n"
			+ "    \"creationTime\": \"2022-09-28T19:53:25.244+00:00\",\r\n"
			+ "    \"lastModTime\": \"2022-09-28T19:53:25.244+00:00\"\r\n"
			+ "}")
       		.when()
			.put("/putprogram/1539");

}
	
@Then("Validate status code")
public void validate_status_code() {
		
	logger.info("Status code" +response.statusCode());
	logger.info("Status code of PUT Request"+response.statusCode());
	Assert.assertEquals(response.getStatusCode(),200);
	response.prettyPrint();
	
		
}

@Then("Validate ProgramId,ProgramName,ProgramDescription,ProgramStatus")
public void validate_program_id_program_name_program_description_program_status() {
	logger.info("ProgramID :"+response.jsonPath().get("programId"));
	logger.info("ProgramName :"+response.jsonPath().get("programName"));
	logger.info("ProgramDescription:"+response.jsonPath().get("programDescription"));
	logger.info("ProgramStatus :"+response.jsonPath().get("programStatus"));

}
}




