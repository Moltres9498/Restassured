package Reqst_Chain;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class GetAllUsersAndGetParticularUser {

	@Test

	public void GetAllUserandGetParUser() {

		baseURI="https://reqres.in";

		Response resp = when()
				.get("/api/users");

		Object id = resp.jsonPath().get("data[0].id");

//		given()
//		.pathParam("uid", id)

		when()
		.get("/api/users/"+id+"")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}