package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Shopperlogin {

	@SuppressWarnings("unchecked")
	@Test
	
	public void login() {
		
		baseURI="https://www.shoppersstack.com/shopping";
		
		JSONObject json=new JSONObject();
		json.put("email", "abc563769@gmail.com");
		json.put("password", "aa132vd");
		json.put("role", "SHOPPER");
		
		given()
		.body(json)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/users/login")
		
		.then()
		.log().all();
	}
}
