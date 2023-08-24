package Resp_valid;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;

public class ReqresDynamicRespValid {
	@Test

	public void Dynamicrespvalid() {
		baseURI="https://reqres.in";

		int expdata=12;

		Response resp=when().get("/api/users?page=2");

		List<Integer> actdata = resp.jsonPath().get("data.id");

		Boolean flag=false;

		for(int id:actdata)
		{
				if(id==expdata)
				{
					flag=true;
				}
		}
		Assert.assertTrue(flag);
		System.out.println("Data is present"+expdata);
	}
}