package api_tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.DataReader;

public class CustomerManagement {
	
	String token;
	int itemId;
	String itemName;
	Response response;
	BrowserUtils utils;
	DButils dbutils;
	File requestBody;
	String endpoint;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = DataReader.getProperty("baseURL");
	}
	
	@Test
	public void login() {
		requestBody = new File("./src/test/resources/json_files/login.json");
		endpoint = DataReader.getProperty("loginURI");
		
		// making the request
		response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.body(requestBody)
		.post(endpoint).thenReturn();
		
		response.prettyPrint();
	    token = response.jsonPath().getString("token");
	}
	
	@Test(dependsOnMethods="login")
	public void createCustomer() {
		
		dbutils = new DButils();
		requestBody = new File("./src/test/resources/json_files/createCustomer.json");
		endpoint = DataReader.getProperty("createCustomerURI");
		
		response = given()
	    		.header("Authorization", "Bearer " + token)
	    		.contentType(ContentType.JSON)
	    		.body(requestBody)
	    .when()
	    		.post(endpoint);
	    
	    //handling redirection manually
	    if (response.statusCode() == 302) {
	        String redirectUrl = response.header("Location");
	        // Manually follow the redirection
	        response = given()
	                .baseUri(redirectUrl)
	                .when()
	                .get();
	    }
	    
	    int expectedStatusCode = 200;
	    Assert.assertEquals(expectedStatusCode, response.getStatusCode());
	    
	    JsonPath json = new JsonPath(requestBody);
		String testName = json.getString("name");
		String testEmail = json.getString("email");
	
		String query = "SELECT * FROM customers WHERE email = \"" + testEmail + "\"";
		List<String> queryResult = dbutils.selectArecord(query);
		
		Assert.assertEquals(queryResult.get(2), testName);
		Assert.assertEquals(queryResult.get(3), testEmail);
		
		String deleteTestCustomer = "DELETE FROM customers WHERE id = \"" + queryResult.get(0) + "\"";
		dbutils.deleteRecord(deleteTestCustomer);

	}
	
	@Test
	public void incorrectAuth() {
		dbutils = new DButils();
		requestBody = new File("./src/test/resources/json_files/createCustomer.json");
		endpoint = DataReader.getProperty("createCustomerURI");
		
		response = given()
	    		.header("Authorization", "Bearer")
	    		.contentType(ContentType.JSON)
	    		.body(requestBody)
	    .when()
	    		.post(endpoint);
		
		int expectedStatusCode = 401;
		String expectedMessage = "Unauthenticated";
	    Assert.assertEquals(expectedStatusCode, response.getStatusCode());
	    Assert.assertEquals(expectedMessage, response.jsonPath().getString("message"));
	}
	
	@Test(dependsOnMethods="login")
	public void incorrectEndpoint() {
		dbutils = new DButils();
		requestBody = new File("./src/test/resources/json_files/createCustomer.json");
		endpoint = "incorrectEndPointTest";
		
		response = given()
	    		.header("Authorization", "Bearer " + token)
	    		.contentType(ContentType.JSON)
	    		.body(requestBody)
	    .when()
	    		.post(endpoint);
		
		int expectedStatusCode = 404;
	    Assert.assertEquals(expectedStatusCode, response.getStatusCode());
	}
	
	@Test(dependsOnMethods="login")
	public void incorrectRequestBody() {
		dbutils = new DButils();
		String incReqBody = "Incorrect Requset Body";
		endpoint = DataReader.getProperty("createCustomerURI");
		
		response = given()
	    		.header("Authorization", "Bearer " + token)
	    		.contentType(ContentType.JSON)
	    		.body(incReqBody)
	    .when()
	    		.post(endpoint);
		
		int expectedStatusCode = 422;
	    Assert.assertEquals(expectedStatusCode, response.getStatusCode());
	}
	
}
