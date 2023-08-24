package Schema_Validation;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import static  io.restassured.RestAssured.*;
import java.io.File;

public class Reqres_Json_Schema {

	@Test
	
	public void JsonValidation() {
		
		baseURI="https://reqres.in";
		
		File file=new File("./Schema.json");
		
		when()
		.get("/api/users/?page=2")
		
		
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(file))
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}
}