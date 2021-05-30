package sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get01 {
	@Test
	void getAllEmployee() {
		 //Specify base URI
		  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"/employees");
		  
		  JsonPath jpath=response.jsonPath();
		System.out.println(jpath.get("data[0].employee_name"));
		
		
		
	}

}
