package RMG_YANTRA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@SuppressWarnings({ "static-access", "unchecked" })
	@Test
	
	public void UpdateProjectInRMG() {
		JSONObject json = new JSONObject();
		json.put("createdBy","Madhunms");
		json.put("projectName","Estron@HrM");
		json.put("status","done");
		json.put("teamSize",5);
		RequestSpecification rest = new RestAssured().given();
		rest.body(json);
		rest.contentType(ContentType.JSON);
		Response resp = rest.put("http://rmgtestingserver:8084/projects/TY_PROJ_24286");
		System.out.println(resp.asPrettyString());
		System.out.println(resp.getStatusCode());
	}
}