package Reqres_BDD_Approach;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class UpdateUserByBDD {

	@SuppressWarnings("unchecked")
	@Test
	
	public void UpdateUser() {
		baseURI="https://reqres.in";
		
		JSONObject json=new JSONObject();
		json.put("name","kiran");
		json.put("job","lead");
		
		given()
		.body(json)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();		
	}
}