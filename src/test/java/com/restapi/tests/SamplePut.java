package com.restapi.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePut {

	@Test
	public void UpdateRecords(){
		 int id = 100;
		 
		 RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("title", "test title 100");
		 requestParams.put("body", "test body 100");
		 
		 request.body(requestParams.toJSONString());
		 Response response = request.put("/posts/"+ id);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		  
		 }		
}
