package Interview_Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class API_Chaining_Reqres_ByBuilders {

	@Test

	public void ChainingByBuilders() {

		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in").build();

		ResponseSpecification respbld = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(200).build();

		Response resp = given()
				.spec(req)

				.when()
				.get("/api/users");

		Object id = resp.jsonPath().get("data[0].id");

		given()
		.spec(req)
		.pathParam("uid", id)

		.when()
		.get("/api/users/{uid}")

		.then()
		.assertThat()
		.spec(respbld)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}