package RMG_YANTRA_BDD_Approach;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class UpdateProjectByBDD {
	@SuppressWarnings("unchecked")
	@Test

	public void UpdateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		JSONObject json=new JSONObject();
		json.put("createdBy","Moltres123");
		json.put("projectName","HRM_RMG ");
		json.put("status","doneok");
		json.put("teamSize",7);

		given()
		.body(json)
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