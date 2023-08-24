package Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUser {

	@SuppressWarnings("static-access")
	@Test
	
	public void DeleteUserInReqres() {
		
		RestAssured rest = new RestAssured();
		Response resp = rest.delete("https://reqres.in/api/users/2");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getContentType());
	}
}