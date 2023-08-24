package RMG_YANTRA_BDD_Approach;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class CreateProjectByBDD {
	JavaLibrary jlib=new JavaLibrary();

	@SuppressWarnings("unchecked")
	@Test

	public void CreateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		JSONObject json=new JSONObject();
		json.put("createdBy","Moltres");
		json.put("projectName","HRM_RMG "+jlib.GetRandomNumber());
		json.put("status","done");
		json.put("teamSize",5);

		given()
		.body(json)
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