package com.juaracoding.restassured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestTwentyTwo {
	@Test (priority = 1)
	public void testPut() {

		JSONObject request = new JSONObject();
		request.put("name", "Bana");
		request.put("category", "TestNG");
		request.put("price", "1800");
		System.out.println(request.toJSONString());

		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://mern-backend-8881.herokuapp.com/products/62e2116cf0e24546b900e063")
		.then()
		.statusCode(200)
		.log()	
		.all();

	}

	@Test (priority = 2)
	public void testPatch() {
		JSONObject request = new JSONObject();
		request.put("name", "Bana");
		request.put("price", "20");
		System.out.println(request.toJSONString());

		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("https://mern-backend-8881.herokuapp.com/products/62b414789561ff15439844c7")
		.then()
		.statusCode(200)
		.log()	
		.all();

	}

	@Test (priority = 3)
	public void testDelete() {
		when()
		.delete("https://mern-backend-8881.herokuapp.com/products/62e20af4f0e24546b900e03e")
		.then()
		.statusCode(204)
		.log().all();

	}
}
