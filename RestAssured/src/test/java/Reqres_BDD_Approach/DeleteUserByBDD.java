package Reqres_BDD_Approach;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserByBDD {

	@Test

	public void DeleteUser () {
		baseURI="https://reqres.in";

		when()
		.delete("/api/users/2")

		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
}