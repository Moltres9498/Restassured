package Reqres_BDD_Approach;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class CreateUserByBDD {

	JavaLibrary jlib=new JavaLibrary();

	@SuppressWarnings("unchecked")
	@Test
	
	public void Createuser() {
		baseURI="https://reqres.in/";
	
		JSONObject json = new JSONObject();
		json.put("name","NMS");
		json.put("job","tester");
		
		given()
		.body(json)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}