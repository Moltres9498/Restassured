package Interview_Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import com.restassured.pojoclass.RMG_YANTRA_PojoClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class Builders_Pre_Condition_RMG {

	@Test

	public void PreCondition() {

		JavaLibrary jlib=new JavaLibrary();

		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass("nms","hrm "+jlib.GetRandomNumber()+"","done",5);

		RequestSpecification req=new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201).build();

		given()
		.spec(req)
		.body(rmg)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.spec(resp)
		.time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
}