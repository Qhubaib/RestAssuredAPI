package getRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTData {
	
	//in case you have put the same data again and again even though it will give you 200 Response
	
	@Test
	public void postTest()
	{
		RequestSpecification request=RestAssured.given();
		
		request.headers("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id","78");
		json.put("title", "this is put operation means updating");
		json.put("author", "Syed Ahmed");
		
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:3000/posts/78");
		
		int responcecode = response.getStatusCode();
		System.out.println("The Response code is: "+responcecode);
		
		Assert.assertEquals(responcecode, 200);
		System.out.println("Status message " + response.body().asString());
		
	}

}
