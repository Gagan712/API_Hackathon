package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.logger;

public class dataSize_SD {
	public static String baseurl = "https://lms-backend-service.herokuapp.com/lms";
	public static Response response;
	public static RequestSpecification request;
	
@Given("User get the Base URL")
public void user_get_the_base_url() {
	logger.info("Use get the Base URI");
	RestAssured.baseURI =baseurl;
}

@When("User make the Get all data Request")
public void user_make_the_get_all_data_request() {
	logger.info("User make a Get request");
	request=RestAssured.given();
	response = request
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			 .get("/allPrograms");
}

@Then("Get the size of Data")
public void get_the_size_of_data() {
	JsonPath js = new JsonPath(response.asString());
	int size = js.getInt("data.size()");
	System.out.println("No of Items in Program Data    "+size);
}
@Given("User get the Base URL for Batch")
public void user_get_the_base_url_for_batch() {
	logger.info("Use get the Base URI");
	RestAssured.baseURI =baseurl;
}

@When("User make the Get all data Request for Batch")
public void user_make_the_get_all_data_request_for_batch() {
	logger.info("User make a Get request");
	request=RestAssured.given();
	response = request
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			 .get("/batches");
}

@Then("Get the size of Data for Batch")
public void get_the_size_of_data_for_batch() {
	JsonPath js = new JsonPath(response.asString());
	int size = js.getInt("data.size()");
	System.out.println("No of Items in Batch Data  "+size);
}

}
