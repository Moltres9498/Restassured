package Interview_Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.*;

public class HowToCheckResponseIsJsonObj_Arr_PlainStr {

	@Test

	public void GetUser() {

		baseURI="https://reqres.in/";

		//		Response resp = given()													//1st-way
		//		.get("api/users/2");
		//		.then()
		//		.assertThat()
		//		.body("",Matchers.instanceOf(Map.class))  // Map for checking JSON Object i.e, ""-> for selecting whole response body and Map.class-> as in key and value pair   
		//	 //.body("",Matchers.instanceOf(List.class))   // List for checking JSON Object i.e, ""-> for selecting whole response body and List.class-> key and value pair in array
		//		.statusCode(200)
		//		.contentType(ContentType.JSON)
		//		.log().all();


		Response resp = given()									// 2nd-way
				.get("api/users?page=2");
		String body=resp.getBody().asPrettyString();
		try {
			ObjectMapper obj = new ObjectMapper();
			JsonNode jsonnode = obj.readTree(body);
			if(jsonnode.isArray()) {
				System.out.println("Its an array response");
			}
			if(jsonnode.isObject()) {
				System.out.println("Its an Object Response");
			}
		} catch (Exception e) {

		}
	}
}