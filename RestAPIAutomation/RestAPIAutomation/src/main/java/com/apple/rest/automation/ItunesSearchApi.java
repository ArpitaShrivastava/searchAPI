package com.apple.rest.automation;

import java.io.IOException;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


public class ItunesSearchApi 
{
	@Test
    public HttpResponse httpClientAutomation() throws ClientProtocolException, IOException
    {
		HttpClient http = HttpClientBuilder.create().build();		
		//HttpParams- build request params
    	HttpGet req= new HttpGet("https://itunes.apple.com/search?term=jack+johnson");
    	req.addHeader("content-type", "application/json");
    	
    	
    	HttpResponse response = http.execute(req);
        
        return response;
    }
}
