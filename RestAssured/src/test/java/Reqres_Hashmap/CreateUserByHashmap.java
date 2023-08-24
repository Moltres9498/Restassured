package Reqres_Hashmap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreateUserByHashmap {

	JavaLibrary jlib=new JavaLibrary();

	@Test
	
	public void Createuser() {
		baseURI="https://reqres.in/";
	
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("name","NMS");
		map.put("job","tester");
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.time(Matchers.lessThan(10000l),TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}