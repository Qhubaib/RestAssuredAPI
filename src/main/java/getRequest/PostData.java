package getRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {
	
	/***
	 * Put,delete,get - these 3 methods will not create additional load on server while making multiple calls
	 * Post - this made to create load on server if made multiple calls
	 * 3 methods if you call them 'n' no.f times it will not create additional resource on server
	 * 
	 * GET - this method simply retrieves the data from server - No changes to server/resource
	 *   Ex: Whenever we are doing browsing - it means get method(Which means you are not doing any changes simply retrieving)
	 * 		Checking any news, searching anything on web and so on.
	 * POST - Every post method will perform changes to the server. In simple words always creates resources to server.
	 *   Ex: Uploading a file/picture on facebook/any other application - sending a tweet or Submitting the form and so on.
	 *   	In this case it makes changes to the server.
	 *   NOTE: if you retry the POST request N no.of times - you will end up having N resources with N different URI's created on server
	 * DELETE:this method is simply delete the data/resources from server
	 *   Ex: Deleting any pictures/file from account and so on.
	 * PUT: when you want to update the existing resource. In simple words this method can update the existing file on server.
	 *   Ex: Updating address/changing the name , renaming the files and so on.
	 * URI - Unified Resource Identifier, URL - Unified Resource Locator, URN - Unified Resource Name
	 * URL - URI of Location, URN - URI of Name (name can be multiple so we dont use this usually) , URI - URI of Locator and Name both (URL+URN)
	 * 
	 * In case if you post the same data again it will give 500 response
	 */
	
	@Test
	public void postTest()
	{
		RequestSpecification request=RestAssured.given();
		
		request.headers("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id","787");
		json.put("title", "my first program of post operation");
		json.put("author", "Syed Qhubaib Ahmed");
		
		request.body(json.toJSONString());
		Response response = request.post("http://localhost:3000/posts");
		
		int responcecode = response.getStatusCode();
		System.out.println("The Response code is: "+responcecode);
		
		Assert.assertEquals(responcecode, 201);
		System.out.println("Status message " + response.body().asString());
		
	}

}
