package Reqres_PojoClass;

import org.testng.annotations.Test;

import com.restassured.pojoclass.ReqresPojoClass;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class UpdateUserByPojoClass {

	@Test

	public void UpdateUser() {
		baseURI="https://reqres.in";

		ReqresPojoClass rep=new ReqresPojoClass("NMS", "SDET");

		given()
		.body(rep)
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