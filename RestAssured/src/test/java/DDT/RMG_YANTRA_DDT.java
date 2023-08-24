package DDT;

import org.testng.annotations.Test;
import com.restassured.genric.RMG_DataProvider;
import com.restassured.pojoclass.RMG_YANTRA_PojoClass;
import com.restassured.genric.JavaLibrary;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class RMG_YANTRA_DDT {
	JavaLibrary jlib=new JavaLibrary();

	@Test(dataProvider = "getdata", dataProviderClass = RMG_DataProvider.class)

	public void CreateProject(String createdBy, String projectName, String status, int teamSize) {
		baseURI="http://rmgtestingserver";
		port=8084;

		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass(createdBy,projectName +jlib.GetRandomNumber(),status,teamSize);

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