package restAssuredTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class PUT_Request {
	
	public Map map = new HashMap();
	int id=7;
	
	@BeforeTest
	public void setup()
	{
		map.put("title", RestUtils.getTitle());
		map.put("author", RestUtils.getAuthor());
		
		RestAssured.baseURI="http://localhost:3000/posts";
		RestAssured.basePath= "/"+id;
	}

	@Test
	public void putdata()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log()
			.all();
	}
}
