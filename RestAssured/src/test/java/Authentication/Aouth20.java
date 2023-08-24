package Authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class Aouth20 {

	@Test
	
	public void Aouth(){
		
		baseURI="http://coop.apps.symfonycasts.com";
		
		Response resp = given()
		.formParam("client_id","Zapdos")
		.formParam("client_secret","9dda64cf28097aad68f7f0484ec95581")
		.formParam("grant type","client_credentials")
		.formParam("redirect_uri ","http://zapdos.com")
		.formParam("code","authorization_code")
		
		.when()
		.post("/token");
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		resp.then().log().all();
		
		given()
		.auth()
		.oauth2(token)
		.pathParam("cid", 4641)
		
		.when()
		.post("/api/{cid}/eggs-count")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
}