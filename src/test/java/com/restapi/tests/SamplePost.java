package com.restapi.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePost {
	
   @Test
	 public void samplePostMethod()
	 {   
	 RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";

	 RequestSpecification httpRequest = RestAssured.given();
	
	 JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "101"); 
		requestParams.put("id", "101");
		requestParams.put("title", "test title1");
		requestParams.put("body", "test body1");
	
		httpRequest.header("Content-Type", "application/json");  //not mandatory
		httpRequest.body(requestParams.toJSONString());
	
	//Response response = httpRequest.post("/register");
	 Response response = httpRequest.request(Method.POST);
		
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 201);
	System.out.println(response.body().asString());
	String title = response.jsonPath().get("title");
	Assert.assertEquals( title, "test title1");
   }

}
