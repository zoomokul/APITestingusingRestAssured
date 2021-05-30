package APITestingusingRestAssured.APITestingusingRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * response içinde response body,header,status code,statusline hepsi var
 */

public class TC005_GET_json_Validation {
	@Test
	void getWeatherDetails() {
		 //Specify base URI
		  RestAssured.baseURI="https://restcountries.eu/rest/v2/capital";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"/Ankara");
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  Assert.assertEquals(responseBody.contains("Ankara"), true);
		  
		 
	
		 
}

}
