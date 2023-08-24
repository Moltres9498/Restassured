package RMG_YANTRA;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@SuppressWarnings("static-access")
	@Test
	
	public void DeleteProjectInRMG() {
		RestAssured rest = new RestAssured();
		Response resp = rest.delete("http://rmgtestingserver:8084/projects/TY_PROJ_24286");
		System.out.println(resp.getStatusCode());
	}
}