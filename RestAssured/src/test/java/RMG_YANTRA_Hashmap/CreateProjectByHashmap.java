package RMG_YANTRA_Hashmap;

import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class CreateProjectByHashmap {
	JavaLibrary jlib=new JavaLibrary();

	@Test

	public void CreateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("createdBy","Moltres");
		map.put("projectName","HRM_RMG "+jlib.GetRandomNumber());
		map.put("status","done");
		map.put("teamSize",5);

		given()
		.body(map)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}