package APITestingusingRestAssured.APITestingusingRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Validation_each_json {

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
			  
			  
			 JsonPath jpath=response.jsonPath();
			 System.out.println(jpath.get("name[0]"));
			 System.out.println(jpath.get("topLevelDomain"));
			 System.out.println(jpath.get("alpha3Code"));
			 System.out.println(jpath.get("callingCodes"));
			 System.out.println(jpath.get("capital"));
			 System.out.println(jpath.get("altSpellings[0][3]")); //[TR, Turkiye, Republic of Turkey, Türkiye Cumhuriyeti]
			 System.out.println(jpath.get("borders"));
			 
			 
			 Assert.assertEquals(jpath.get("name[0]"), "Turkey");
			  
			 
		
			 
	}

}
