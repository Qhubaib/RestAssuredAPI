package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteData {
	/***
	 * json commands we need to use 
	 *    ****  npm install -g json-server	****
	 *    **** json-server --watch db.json  ****
	 *    
	 *    in case of delete - if you try to delete the record which is already deleted you will get 404 Response
	 */
	
	@Test
	public void deleteTest()
	{
		
		Response response = RestAssured.delete("http://localhost:3000/posts/1235");
		
		int responsecode = response.getStatusCode();
		
		System.out.println("Response code is: "+responsecode);
		
		Assert.assertEquals(responsecode, 200);
		
		System.out.println("Status message " + response.body().asString());
		
	}

}
