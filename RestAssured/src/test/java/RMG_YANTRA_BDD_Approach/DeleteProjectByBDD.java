package RMG_YANTRA_BDD_Approach;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DeleteProjectByBDD{

	@Test

	public void DeleteProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		when()
		.delete("/projects/TY_PROJ_24417")

		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
}