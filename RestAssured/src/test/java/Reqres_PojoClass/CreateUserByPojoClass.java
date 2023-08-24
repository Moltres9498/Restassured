package Reqres_PojoClass;

import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import com.restassured.pojoclass.ReqresPojoClass;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class CreateUserByPojoClass {

	JavaLibrary jlib=new JavaLibrary();

	@Test

	public void Createuser() {
		baseURI="https://reqres.in/";

		ReqresPojoClass rep=new ReqresPojoClass("Madhu", "Engg");

		given()
		.body(rep)
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