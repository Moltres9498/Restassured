package Interview_Practice;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class HowToSendCookiesUsingMap {

	@Test

	public void GetUser() {

		baseURI="https://reqres.in/";

		HashMap<String, String> cookies = new HashMap<String, String>();
        cookies.put("cookieName1", "cookieValue1");
        cookies.put("cookieName2", "cookieValue2");
		
        given()
        .cookies(cookies)
        
		.when()
		.get("api/users/2")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}