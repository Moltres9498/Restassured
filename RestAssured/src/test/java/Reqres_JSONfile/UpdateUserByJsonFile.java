package Reqres_JSONfile;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.File;

public class UpdateUserByJsonFile {

	@Test

	public void UpdateUser() {
		baseURI="https://reqres.in";

		File file=new File("./Reqresdata.json");

		given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.put("/api/users/2")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();		
	}
}