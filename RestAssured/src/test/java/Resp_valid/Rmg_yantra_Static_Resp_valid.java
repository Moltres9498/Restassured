package Resp_valid;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Rmg_yantra_Static_Resp_valid {

	@Test

	public void GetProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		String expdata="TY_PROJ_12318";

		Response resp=when().get("/projects");

		String proid = resp.jsonPath().get("[0].projectId");

		Assert.assertEquals(proid, expdata);
		System.out.println("It is verified");
	}
}