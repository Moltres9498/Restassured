package Authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Bearer_token_get_repo {

	@Test
	
	public void GetRepo() {
		baseURI="https://api.github.com";
		
		given()
		.auth().oauth2("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")
		.pathParam("owner", "Moltres9498")
		.pathParam("repo", "Postman")
		
		.when()
		.get("/repos/{owner}/{repo}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}