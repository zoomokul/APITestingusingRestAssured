package APITestingusingRestAssured.APITestingusingRestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	void RegistrationSuccessful()
	 {
		 //Specify base URI
		  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		
		  requestParams.put("employee_name", "Ahmet");
		  requestParams.put("employee_salary", 5000);
		  requestParams.put("employee_age", 20);
		
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/create");
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  
		  //success code validation
		  String successCode=response.jsonPath().get("message");
		  Assert.assertEquals(successCode, "Successfully! Record has been added.");
	 }

}
