package step_definitions;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import io.restassured.response.Response;
import utilities.DButils;
import utilities.DataReader;
import static io.restassured.RestAssured.given;

import java.util.List;

public class CustomersManagementSteps {
	
	static Response response;
	static JSONObject requestBodyLogin;
	static JSONObject requestBodyCreateCust;
	static private String authToken;
	DButils dbutils = new DButils();
	
	@Given("I am an authorized customer of Create customer webservice with following credentials")
	public void i_am_an_authorized_customer_of_create_customer_webservice_with_following_credentials(String body) {
		requestBodyLogin = new JSONObject(body);
		response = given()
	    		.body(requestBodyLogin.toString())
	    		.contentType(ContentType.JSON)
	    	.when()
	    		.post(DataReader.getProperty("loginURI"));
		
		authToken = response.jsonPath().getString("token");
		
	}
	@When("I make POST request with following request body")
	public void i_make_post_request_with_following_request_body(String body) {
		requestBodyCreateCust = new JSONObject(body);
		response = given()
	    		.header("Authorization", "Bearer " + authToken)
	    		.contentType(ContentType.JSON)
	    		.body(requestBodyCreateCust.toString())
	    .when()
	    		.post(DataReader.getProperty("createCustomerURI"));
	    
	    //handling redirection manually
	    if (response.statusCode() == 302) {
	        String redirectUrl = response.header("Location");
	        // Manually follow the redirection
	        response = given()
	                .baseUri(redirectUrl)
	                .when()
	                .get();
	    }
	}
	@Then("I should get HTTP Status Code {int}")
	public void i_should_get_http_status_code(int expectedStatusCode) {
		Assert.assertEquals(expectedStatusCode, response.getStatusCode());
	}
	@Then("a customer should be created in app database")
	public void a_customer_should_be_created_in_app_database(DataTable data) {
		List<String> listData = data.asList();
		String query = "SELECT * FROM customers WHERE email = " + listData.get(1);
		List<String> queryResult = dbutils.selectArecord(query);
		
		Assert.assertEquals(queryResult.get(2), listData.get(0));
		Assert.assertEquals(queryResult.get(3), listData.get(1));
	}
	
	
	
}
