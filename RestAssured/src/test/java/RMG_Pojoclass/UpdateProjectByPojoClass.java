package RMG_Pojoclass;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import com.restassured.pojoclass.RMG_YANTRA_PojoClass;

import io.restassured.http.ContentType;

public class UpdateProjectByPojoClass {

	@Test

	public void UpdateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass("nmsabc","netopt","doneok",6);

		given()
		.body(rmg)
		.contentType(ContentType.JSON)

		.when()
		.put("/projects/TY_PROJ_24562")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}