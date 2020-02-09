package restAssuredTest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE_Request {
	
	int id=7;
	
	@Test
	public void deleteData()
	{
		RestAssured.baseURI="http://localhost:3000/posts";
		RestAssured.basePath="/"+id;
		
		Response resp=
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.log()
			.all()
			.extract()
			.response();
		String jsonAsString = resp.body().asString();
		System.out.println(jsonAsString);
		String jsonAsString1 = resp.asString();
		System.out.println(jsonAsString1);
		
	}

}
