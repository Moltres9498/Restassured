package RMG_YANTRA_Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class GetProjectByPathparameter {

	@Test
	
	public void CreateProjectByPath() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.pathParam("pid", "TY_PROJ_24678")
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}	
}