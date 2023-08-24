package RMG_YANTRA_JsonFile;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class CreateProjectByJsonFile {
	JavaLibrary jlib=new JavaLibrary();

	@Test

	public void CreateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		File file=new File("./Rmg_yantra_data.json");

		given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}