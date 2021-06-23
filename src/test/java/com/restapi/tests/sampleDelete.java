package com.restapi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sampleDelete {

	@Test
	public void sampleDelete() {
	 int id = 100;
	 
	 RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	 RequestSpecification request = RestAssured.given(); 
	 
	 // Add a header stating the Request body is a JSON
	 request.header("Content-Type", "application/json"); 
	 
	       // Delete the request and check the response
	 Response response = request.delete("/posts/"+ id); 
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, 200);
	 
	 String jsonString =response.asString();
	 System.out.println(jsonString);
	 
	 }

}
