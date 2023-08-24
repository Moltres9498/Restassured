package Interview_Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.io.File;

public class HowToUploadImages {

	@Test
	
	public void Image() {
		
		baseURI="https://petstore.swagger.io/v2";
		
		given()
		.pathParam("pid", 1)
		.multiPart("additionalMetadata","abc")
		.multiPart(new File("./config/gojo.png"))
		
		.when()
		.post("/pet/{pid}/uploadImage")
		
		.then()
		.log().all();
	}	
}