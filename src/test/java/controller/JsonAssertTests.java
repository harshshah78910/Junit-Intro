package controller;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class JsonAssertTests {

	String expectedResult = "{\"id\":1,\"name\":\"Iphone\",\"price\":233,\"quantity\":1}";
	
	@Test
	public void jsonAssert_StrictTrue() throws JSONException
	{
		String actual = "{\"id\":1,\"name\":\"Iphone\",\"price\":233,\"quantity\":1}";
		JSONAssert.assertEquals(expectedResult, actual, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException
	{
		String actual = "{id:1,name:Iphone,quantity:1}";
		JSONAssert.assertEquals(actual, expectedResult, false);
	}
	
}
