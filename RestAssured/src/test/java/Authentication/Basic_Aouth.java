package Authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class Basic_Aouth {

	@Test
	
	public void Auth1() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		//.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		//.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}