package RMG_YANTRA_JsonFile;

import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class UpdateProjectByJsonfile {
	@Test

	public void UpdateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		File file=new File("./Rmg_yantra_data.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.put("/projects/TY_PROJ_24550")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}