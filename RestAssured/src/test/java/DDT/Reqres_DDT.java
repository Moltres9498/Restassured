package DDT;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restassured.genric.Reqres_DataProvider;
import com.restassured.pojoclass.ReqresPojoClass;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class Reqres_DDT {
	
	@Test(dataProvider = "Data", dataProviderClass = Reqres_DataProvider.class )

	public void Reqres( String name, String job) {
		
		baseURI="https://reqres.in";
		
		ReqresPojoClass req=new ReqresPojoClass(name, job);
		
		given()
		.body(req)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}