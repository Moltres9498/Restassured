package Reqres;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUser {

	@SuppressWarnings("static-access")
	@Test
	
	public void GetUserInReqres() {
		
		RestAssured rest = new RestAssured();
		Response resp = rest.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.asPrettyString());
		System.out.println(resp.getStatusCode());
	}
}