package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUser {

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	
	public void UpdateUserInReqres() {
		JSONObject json = new JSONObject();
		json.put("name","kiran");
		json.put("job","Engineer");
		RequestSpecification rest = new RestAssured().given();
		rest.body(json);
		rest.contentType(ContentType.JSON);
		Response resp = rest.put("https://reqres.in/api/users/2");
		System.out.println(resp.prettyPrint());
		System.out.println(resp.getStatusCode());
	}
}
