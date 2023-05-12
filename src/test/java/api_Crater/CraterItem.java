package api_Crater;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.BrowserUtils;
import utilities.DataReader;

public class CraterItem {

	

	String token;
	int itemId;
	String itemName;
	Response response;
	BrowserUtils utils;
	String baseUrl = "http://crater.primetech-apps.com/api";
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://crater.primetech-apps.com";
	}

	
	@Test
	public void login() {
		String endpoint = "/api/v1/auth/login";
	    // setting the request body to map	
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("username", DataReader.getProperty("username"));
		requestBody.put("password", DataReader.getProperty("password"));
		requestBody.put("device_name", DataReader.getProperty("device_name"));
		
		// making the request
		response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.body(requestBody)
		.post(endpoint).thenReturn();
		
		response.prettyPrint();
	    token = response.jsonPath().getString("token");
	}
	

	
	@Test (priority = 1)
	public void invalidScenario() {
		String loginEndpoint = "/v1/auth/login";
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("username", DataReader.getProperty("username"));
		requestBody.put("password", DataReader.getProperty("password"));
		requestBody.put("device_name", DataReader.getProperty("device_name"));
		
		
		response = RestAssured.given()
		.accept("application/json")
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.post(baseUrl + loginEndpoint)
		.thenReturn();
		
		response.prettyPrint();
		
		response.then().statusCode(200);
		token = response.jsonPath().getString("token");
		
	}
	
	
	@Test (dependsOnMethods = "login", priority = 2)
	public void logout() {
		
		String logoutEndpoint = "/v1/auth/logout";
		
		response = RestAssured.given()
		.accept("application/json")
		.contentType(ContentType.JSON)
		.auth().oauth2("Bearer "+token+"")
		.post(baseUrl + logoutEndpoint)
		.thenReturn();
		
		response.prettyPrint();
		
		response
		.then().statusCode(200)
		.body("success", Matchers.equalTo(true));
		
		
	}
	
	
	@Test (priority = 3)
	public void logoutWithIncorrectAuthorization() {
		
		String logoutEndpoint = "/v1/auth/logout";
		
		response = RestAssured.given()
		.accept("application/json")
		.contentType(ContentType.JSON)
		.auth().oauth2("Bearer "+token+"")
		.post(baseUrl + logoutEndpoint)
		.thenReturn();
		
		response.prettyPrint();
		
		response
		.then().statusCode(401)
		.body("message", Matchers.equalTo("Unauthenticated."));
		
		
		
	}
	
	@Test (priority = 4)
	public void logoutWithIncorrectEndpoint() {
		
		String logoutEndpoint = "/v1/auth/logout/login";
		
		response = RestAssured.given()
		.accept("application/json")
		.contentType(ContentType.JSON)
		.auth().oauth2("Bearer "+token+"")
		.post(baseUrl + logoutEndpoint)
		.thenReturn();
		
		response.prettyPrint();
		
		response
		.then().statusCode(404);
		
	}
}
