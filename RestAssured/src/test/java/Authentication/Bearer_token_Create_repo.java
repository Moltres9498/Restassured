package Authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restassured.pojoclass.Git_PojoClass;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class Bearer_token_Create_repo {

	@Test

	public void Auth2() {
		baseURI="https://api.github.com";

		Git_PojoClass git=new Git_PojoClass("Postman", "By RestAssured");

		given()
		.body(git)
		.contentType(ContentType.JSON)
		.auth().oauth2("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")

		.when()
		.post("/user/repos")

		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}