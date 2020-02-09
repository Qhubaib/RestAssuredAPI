package restAssuredTest;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * 1. Test Status Code
 * 2. Log Response
 * 3. Verifying Single Content in response body
 * 4. Verifying Multiple Content in response body
 * 5. Setting Parameters & headers
 */

public class BasicValidations {
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI="http://localhost:3000/posts";
	}
	
	//Test Status Code -- Log Response
	@Test(priority=1)
	public void testStatusCodeLogResponse()
	{
		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	
	//3, 4. For Verifying multiple Content in response body use ==> .body("id", hasItems(1,2));
	@Test(priority=2)
	public void multipleContent()
	{
		given()
		.when()
		.get()
		.then()
		.statusCode(200)
		.body("id", hasItems(1,2));
	}
	
	@Test
	public void testParamsAndHeaders()
	{
		given()
		 .param("My Name", "Qhubaib")
		 .header("My Author","Ahmed")
	   .when()
	   	.get()
	   .then()
	   .statusCode(200)
	   .log().all();
	}

}
