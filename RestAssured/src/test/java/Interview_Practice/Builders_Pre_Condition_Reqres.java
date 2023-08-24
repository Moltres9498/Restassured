package Interview_Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restassured.pojoclass.ReqresPojoClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Builders_Pre_Condition_Reqres {

	@Test
	
	public void  PreConditionReqres() {
		
		ReqresPojoClass req=new ReqresPojoClass("nms", "tester");
		
		RequestSpecification reqst = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in")
				.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectResponseTime(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
				.expectStatusCode(201).build();
		
		given()
		.spec(reqst)
		.body(req)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.spec(resp)
		.log().all();
	}
}
