package Interview_Practice;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class MultipleWaysToSendCookies {

	@Test

	public void GetUser() {

		baseURI="https://reqres.in/";

		//		given()																												//1st-way
		//				.cookie("session_id", "1234")
		//				.get("api/users/2");


				Cookie myCookie = new Cookie.Builder("session_id", "1234")						//2nd-way
					      .setSecured(true)
					      .setComment("session id cookie")
					      .build();
				given()
				.cookie("session_id", "1234")
				.cookie(myCookie)
				.when()
				.get("api/users/2");


		//		  RequestSpecification req = new RequestSpecBuilder()							//3rd-way
		//		 .addCookie("session_id", "1234").build();
		//		given()
		//		.spec(req)
		//		.get("api/users/2");


		//		HashMap<String, String> cookies = new HashMap<String, String>();			//4th-way
		//        cookies.put("cookieName1", "cookieValue1");
		//        cookies.put("cookieName2", "cookieValue2");
		//        given()
		//        .cookies(cookies)
		//		.when()
		//		.get("api/users/2");
		
		
		


	}
}