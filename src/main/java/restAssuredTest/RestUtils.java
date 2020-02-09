package restAssuredTest;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	static Random rand;
	
	public static String getId()
	{
		String value=RandomStringUtils.randomNumeric(1);
		return value;
	}
	
	public static String getAuthor()
	{
		String value=RandomStringUtils.randomAlphanumeric(1);
		return "Talbeena "+value;
	}
	
	public static String getTitle()
	{
		String value=RandomStringUtils.randomAlphanumeric(1);
		return "Title "+value;
	}

}
