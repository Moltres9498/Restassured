package Reqres_Hashmap;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class UpdateUserByHashmap {

	@Test
	
	public void UpdateUser() {
		baseURI="https://reqres.in";
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name","kiran");
		map.put("job","lead");
		
		given()
		.body(map)
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