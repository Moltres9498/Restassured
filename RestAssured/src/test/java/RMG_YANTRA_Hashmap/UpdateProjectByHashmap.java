package RMG_YANTRA_Hashmap;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class UpdateProjectByHashmap {

	@Test

	public void UpdateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("createdBy","Moltres123");
		map.put("projectName","HRM_RMG ");
		map.put("status","doneok");
		map.put("teamSize",7);

		given()
		.body(map)
		.contentType(ContentType.JSON)

		.when()
		.put("/projects/TY_PROJ_24417")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}