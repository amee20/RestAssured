package com.RestAssured.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDOperation
{@Test
	public void getTest()
	{ 	Response resp = RestAssured.get("http://localhost:3000/posts");
	int statusCode = resp.getStatusCode();
	System.out.println(statusCode);
	String body = resp.asString();// to get the response body
	System.out.println(body);
	Assert.assertEquals(statusCode, 200);}
		@Test
	public void postTest()
	{RequestSpecification given = RestAssured.given();
		given.header("content-Type","application/json");
		JSONObject jobj = new JSONObject();
		jobj.put("id", 25);
		jobj.put("title","Api");
		jobj.put("author","amee_vora");
		given.body( jobj.toString());//this body method is used to coppy content value to body part
		Response post = given.post("http://localhost:3000/posts");
		int statusCode = post.getStatusCode();
		String asString = post.asString();
		System.out.println(asString);
		Assert.assertEquals(statusCode, 201);}
	@Test
	public void putTest()
	{
		RequestSpecification given = RestAssured.given();
		given.header("content-Type","application/json");
		JSONObject jobj = new JSONObject();
		jobj.put("id", 25);
		jobj.put("title","Api");
		jobj.put("author","amee_vora");
		jobj.put("date", "01-11-201");
		given.body( jobj.toString());//this body method is used to coppy content value to body part
		Response post = given.put("http://localhost:3000/posts/25");// here we need to change the url 
		int statusCode = post.getStatusCode();
		String asString = post.asString();
		System.out.println(asString);
		Assert.assertEquals(statusCode, 200);}
	@Test
	public void patchTest()
	{
		RequestSpecification given = RestAssured.given();
		given.header("content-Type","application/json");
		JSONObject jobj = new JSONObject();
		jobj.put("author","amee_vora20");
		jobj.put("stream","elect");
		given.body( jobj.toString());//this body method is used to coppy content value to body part
		Response post = given.patch("http://localhost:3000/posts/25");//  
		int statusCode = post.getStatusCode();
		String asString = post.asString();
		System.out.println(asString);
		Assert.assertEquals(statusCode, 200);}
	@Test
	public void deleteTest()
	{
		RequestSpecification given = RestAssured.given();
		Response post = given.delete("http://localhost:3000/posts/25");// here we need to change the url 
		int statusCode = post.getStatusCode();
		String asString = post.asString();
		System.out.println(asString);
		Assert.assertEquals(statusCode, 200);}
}
