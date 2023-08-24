package RMG_YANTRA_Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class GetProjectsInReqresByQueryParam {

	@Test
	
	public void GetProjectsByQuery() {
		baseURI="https://reqres.in";
		
		given()
		.queryParam("page",2)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
}
