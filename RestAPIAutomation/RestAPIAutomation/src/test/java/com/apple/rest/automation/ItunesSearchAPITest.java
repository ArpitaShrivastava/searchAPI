package com.apple.rest.automation;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ItunesSearchAPITest 
{
    
	@Test
    public void httpClientAutomationTest() throws ClientProtocolException, IOException
    {
		ItunesSearchApi obj = new ItunesSearchApi();
    	HttpResponse response =obj.httpClientAutomation();
    	
    	int statusCode = response.getStatusLine().getStatusCode();
    	System.out.println(response);
        
        JSONObject jsonObject = new JSONObject(response.getEntity());
       
        System.out.println(jsonObject);
        
		boolean stream = (Boolean) jsonObject.get("streaming");
		
		Assert.assertEquals(true, stream);
		JSONObject contentType = jsonObject.getJSONObject("contentType");
		
		JSONArray elements =  contentType.getJSONArray("elements");
				
		Assert.assertTrue(elements.length()>0);
		
		JSONObject element = elements.getJSONObject(0);
		Assert.assertEquals(1, element.get("parameterCount"));
		
		
        Assert.assertTrue(200==statusCode);
    }

    
}
