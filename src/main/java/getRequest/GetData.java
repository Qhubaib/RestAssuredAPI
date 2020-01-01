package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class GetData {
	
	@Test
	public void testResponsecode()
	{
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		int status=response.getStatusCode();
		
		System.out.println("status is: "+status);
		
		Assert.assertEquals(status, 200);
	}

	@Test
	public void testBody()
	{
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		String data = response.asString();
		
		System.out.println("Data is: "+data);
		
		System.out.println("Response Time is: "+response.getTime());
	}
}
