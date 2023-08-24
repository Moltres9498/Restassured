package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	@SuppressWarnings("unchecked")
	@Test
	
	public void CreateUserInReqres() {
		
		JSONObject json=new JSONObject();
		json.put("name","Madhu");
		json.put("job", "tester");
		
		RequestSpecification rest = RestAssured.given();
		rest.body(json);
		rest.contentType(ContentType.JSON);
		
		Response resp=rest.post("https://reqres.in/api/users");
		
		//System.out.println(resp.asString());
		System.out.println(resp.asPrettyString());
		//System.out.println(resp.prettyPeek());
		System.out.println(resp.getStatusCode());
	}
}