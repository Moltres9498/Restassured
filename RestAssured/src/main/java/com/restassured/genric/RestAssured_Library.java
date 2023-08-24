package com.restassured.genric;

import io.restassured.response.Response;

public class RestAssured_Library {

	/**
	 * This method will return json data from the corresponding response body
	 * @author Madhu.N
	 * @param response
	 * @param path
	 * @return
	 */
	
	public String getjsonresponse(Response resp, String path) {
		String jsondata=resp.jsonPath().get(path);
		return jsondata;
	}	
}