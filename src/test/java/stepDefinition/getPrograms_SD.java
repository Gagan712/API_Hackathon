package stepDefinition;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;
//import static io.restassured.RestAssured.*;
import org.testng.Assert;
import io.cucumber.java.en.*;

public class getPrograms_SD {
	public static String baseurl="https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static int programId;
	public static RequestSpecification request; 
	public static String programName;
	
	@Given("A service with URL")
	public void a_service_with_url() {
		RestAssured.baseURI=baseurl;
	    
	}

	@When("Set request header")
	public void set_request_header() {
		request=RestAssured.given();
	}
	

	@When("Get request is made")
	public void get_request_is_made() {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				 .get("/allPrograms");
	}

	@Then("Validate status code")
	public void validate_status_code() {
		logger.info("Status code" +response.statusCode());
		Assert.assertEquals(200,response.getStatusCode());
		response.prettyPrint();
	    
	}

	@Then("Validate ProgramId,ProgramName,ProgramDescription,ProgramStatus")
	public void validate_program_id_program_name_program_description_program_status() {
		logger.info("ProgramID :"+response.jsonPath().get("programId[0]"));
		logger.info("ProgramName :"+response.jsonPath().get("programName[0]"));
		logger.info("ProgramDescription:"+response.jsonPath().get("programDescription[0]"));
		logger.info("ProgramStatus :"+response.jsonPath().get("programStatus[0]"));
	}

	@Given("A GET service with URL")
	public void a_get_service_with_url() {
		RestAssured.baseURI=baseurl;
	}

	@When("Get request header")
	public void get_request_header() {
		request=RestAssured.given();
	}
	

	@When("Get request is made to get program by Id")
	public void get_request_is_made_to_get_program_by_id() {
		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.get("/programs/1761");
	}

	@Then("Validate status code for Program By Id")
	public void validate_status_code_for_program_by_id() {
		logger.info("Status code" +response.statusCode());
		Assert.assertEquals(200,response.getStatusCode());
		response.prettyPrint();
}	
	

	@Then("Validate ProgramName,ProgramDescription,ProgramStatus")
	public void validate_program_name_program_description_program_status() {
		logger.info("ProgramID :"+response.jsonPath().get("programId"));
        logger.info("ProgramName :"+response.jsonPath().get("programName"));
		logger.info("ProgramDescription:"+response.jsonPath().get("programDescription"));
		logger.info("ProgramStatus :"+response.jsonPath().get("programStatus"));

	}	
}

