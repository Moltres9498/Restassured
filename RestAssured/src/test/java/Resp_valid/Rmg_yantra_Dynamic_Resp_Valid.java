package Resp_valid;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;

public class Rmg_yantra_Dynamic_Resp_Valid {

	@Test

	public void DynamicResp() {
		baseURI="http://rmgtestingserver";
		port=8084;

		String expdata="google61";

		Response resp=given().get("/projects");

		List<String> actdata = resp.jsonPath().get("projectName");

		System.out.println(actdata);

		int count=0;
		for(String id:actdata)
		{
			System.out.println(id);
			count++;
			SoftAssert s=new SoftAssert();
			s.assertEquals(actdata, expdata);
		}
		System.out.println("No of Projects are-->"+count);
		System.out.println("expected data is-->"+expdata);
		System.out.println(" data is found and its verified");
	}
}