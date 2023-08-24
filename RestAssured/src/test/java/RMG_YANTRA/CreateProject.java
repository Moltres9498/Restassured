package RMG_YANTRA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@SuppressWarnings({ "static-access", "unchecked" })
	@Test
	
	public void CreateProjectInRMG9() {
		JSONObject json = new JSONObject();
		json.put("createdBy","Madhu");
		json.put("projectName", "HrmEstron");
		json.put("status", "completed");
		json.put("teamSize", 4);
		RequestSpecification rest = new RestAssured().given();
		rest.body(json);
		rest.contentType(ContentType.JSON);
		Response resp = rest.post("http://rmgtestingserver:8084/addProject");
		System.out.println(resp.asPrettyString());
		System.out.println(resp.getStatusCode());
	}
	}
