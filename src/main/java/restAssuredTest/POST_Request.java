package restAssuredTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class POST_Request {
	
	public Map map = new HashMap();
	
	@BeforeTest
	public void setup()
	{
		map.put("id", RestUtils.getId());
		map.put("title", RestUtils.getTitle());
		map.put("author", RestUtils.getAuthor());
		
		RestAssured.baseURI="http://localhost:3000/posts";
	}

	@Test
	public void postdata()
	{
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201)
		.log()
		.all();
	}
}
