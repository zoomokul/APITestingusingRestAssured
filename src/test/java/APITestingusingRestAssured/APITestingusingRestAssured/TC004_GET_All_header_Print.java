package APITestingusingRestAssured.APITestingusingRestAssured;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_All_header_Print {

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
		  
		 
		  
		  //All header
		  
		  Headers headers=response.headers();
		  
		 for (Header header : headers) {
			 
			 System.out.println(header.getName()+"==============>>"+header.getValue());
			
		}
		 
}
	
}
