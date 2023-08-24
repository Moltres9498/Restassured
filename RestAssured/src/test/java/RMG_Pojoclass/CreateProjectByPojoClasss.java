package RMG_Pojoclass;

import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import com.restassured.pojoclass.RMG_YANTRA_PojoClass;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class CreateProjectByPojoClasss {
	JavaLibrary jlib=new JavaLibrary();

	@Test

	public void CreateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass("nms","estron "+jlib.GetRandomNumber()+"","done",5);

		given()
		.body(rmg)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}