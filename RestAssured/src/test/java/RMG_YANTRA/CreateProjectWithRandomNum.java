package RMG_YANTRA;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectWithRandomNum {

	JavaLibrary jlib=new JavaLibrary();
	
	@SuppressWarnings({ "static-access", "unchecked" })
	@Test
	
	public void CreateProjectWithRandom() {
		JSONObject json = new JSONObject();
		json.put("createdBy","Madhu");
		json.put("projectName", "HrmEstron "+jlib.GetRandomNumber());
		json.put("status", "completed");
		json.put("teamSize", 4);
		RequestSpecification rest = new RestAssured().given();
		rest.body(json);
		rest.contentType(ContentType.JSON);
		Response resp = rest.post("http://rmgtestingserver:8084/addProject");
		System.out.println(resp.asPrettyString());
		//System.out.println(resp.getStatusCode());	
		int status = resp.getStatusCode();
		String text = resp.getStatusLine();
		Assert.assertEquals(201, status);
		System.out.println(status);
		System.out.println(text);

	}
}