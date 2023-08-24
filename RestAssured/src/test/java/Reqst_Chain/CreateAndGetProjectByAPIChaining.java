package Reqst_Chain;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import com.restassured.pojoclass.RMG_YANTRA_PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class CreateAndGetProjectByAPIChaining {

	@Test
	
	public void CreateandGet() {
	
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaLibrary jlib=new JavaLibrary();
		
		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass("nms", "hrm "+jlib.GetRandomNumber()+"","done",5);
	
		Response resp = given()
		.body(rmg)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		String proid = resp.jsonPath().get("projectId");
		
		given()
		.pathParam("pid", proid)
		
		.when()
		.get("/projects/{pid}")

		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();	
	}
}