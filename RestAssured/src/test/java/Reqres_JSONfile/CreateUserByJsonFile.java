package Reqres_JSONfile;

import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.File;

public class CreateUserByJsonFile {

	JavaLibrary jlib=new JavaLibrary();

	@Test

	public void Createuser() {
		baseURI="https://reqres.in/";

		File file=new File("./Reqresdata.json");

		given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.post("/api/users")

		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}