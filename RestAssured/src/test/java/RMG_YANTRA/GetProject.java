package RMG_YANTRA;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {

	@SuppressWarnings("static-access")
	@Test
	
	public void GetProjectInRMG() {
		RestAssured rest = new RestAssured();
		//System.out.println(rest.get("http://rmgtestingserver:8084/projects/TY_PROJ_24286").asPrettyString());
		Response resp = rest.get("http://rmgtestingserver:8084/projects");
		System.out.println(resp.asPrettyString());
		System.out.println(resp.getStatusCode());
	}
}
