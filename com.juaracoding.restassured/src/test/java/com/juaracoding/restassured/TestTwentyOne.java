package com.juaracoding.restassured;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestTwentyOne {
	String endpoint = "https://mern-backend-8881.herokuapp.com/products";

	@Test
	public void testGet() {
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		int actual = response.getStatusCode();
		assertEquals(actual, 200);
	}

	@Test
	public void testPost() {
		JSONObject request = new JSONObject();
		request.put("name", "Bana");
		request.put("category", "Test 5");
		request.put("price", "9999");
		System.out.println(request.toJSONString());

		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://mern-backend-8881.herokuapp.com/products")
		.then()
		.statusCode(201)
		.log()
		.all();
	}
}
