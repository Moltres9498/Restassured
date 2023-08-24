package Interview_Practice;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HowToPassMultipleHeaders {

	@Test

	public void GetUser() {

		baseURI="https://reqres.in/";
		
		Response resp = given()
		.headers("User-Agent", "MyAppName", "Accept-Charset", "utf-8")
		//.headers("My-Header", "val1", "val2")
				
		.when()
		.get("api/users/2");
		System.out.println(resp.getHeaders());
	}
}