package Reqres_BDD_Approach;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class GetUserByBDD {

	@Test

	public void GetUser() {

		baseURI="https://reqres.in/";

		 when()
		.get("api/users/2")


		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}