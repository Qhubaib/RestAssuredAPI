package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authetication extends TestBaseAuthentication {
	
	/***
	 * There are 2 types of authentication preemtive and challenge
	 *  Usually we send the the url & do get the response that of authentication if we give the authentication details only
	 *      it will allow me to get into that URL
	 * 	1. Preemtive : it will pass the authentication details while sending the url itself
	 * 		(Here it is doing 1 time operation)
	 *  2. Challenge : it wont pass the authentication details while sending the url - it will check whether the passed URL
	 *      is asking the authentication details then only it will pass(Here it is doing 2 times operation)
	 */
	
	@Test(enabled=false)
	public void authenticationTest()
	{
		RequestSpecification request=RestAssured.given();
		int responsecode=request.auth()
		.preemptive()
		.basic("ToolsQA", "TestPassword")
		.when()
		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
		.getStatusCode();
		
		System.out.println("The Response code is: "+responsecode);
		Assert.assertEquals(responsecode, 200);
	}

	@Test
	public void authenticationTestThroughBase()
	{
		RequestSpecification request=RestAssured.given();
		Response response=request
		.when()
		.get();	
		int responsecode=response.getStatusCode();
		System.out.println("The Response code is: "+responsecode);
		Assert.assertEquals(responsecode, 200);
		System.out.println("Status message " + response.body().asString());
	}
}
