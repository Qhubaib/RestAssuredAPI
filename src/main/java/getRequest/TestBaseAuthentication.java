package getRequest;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class TestBaseAuthentication {
	
	@BeforeTest
	public void baseAuthentication()
	{
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
	}

}
