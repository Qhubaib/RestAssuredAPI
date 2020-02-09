package restAssuredTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * given() --> set cookies, add authentication, add parameters, set headers info etc....
 * when() --> post,get,put,delete operations etc...
 * then() --> validate status code, extract response, extract headers, cookies, response body etc...
 */

public class GET_Request {
	
	@Test
	public void getResponseTest()
	{
		given()
		.when()
		.get("http://localhost:3000/posts")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat()
		.body("[0].id", equalTo(1))
		//.contentType("application/json; charset=utf-8");
		.header("Content-Type","application/json; charset=utf-8");
		
	}

}
