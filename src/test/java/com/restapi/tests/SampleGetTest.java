package com.restapi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleGetTest {
	
   @Test
	 public void testGetCall()
	 {   
	 
	 RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";

	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.request(Method.GET, "/1");
	
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody);
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("status code is : " +statusCode);
	 Assert.assertEquals(statusCode, 200);
	 String title = response.jsonPath().get("title");
	 Assert.assertTrue(title.contains("sunt aut facere repellat"));
	 
	 }

}
