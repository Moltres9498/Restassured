package RMG_YANTRA_BDD_Approach;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class GetProjectByBDD {

	@Test
	
	public void GetProject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_24678")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}