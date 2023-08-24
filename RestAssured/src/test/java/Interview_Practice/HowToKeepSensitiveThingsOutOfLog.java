package Interview_Practice;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class HowToKeepSensitiveThingsOutOfLog {

	@Test
	
	public void outoflog() {
		
//Response resp = given()
//.header("X-REGION","ABC")
//.config(config.logConfig(LogConfig.logConfig().blacklistHeader(data)))
//.log().all();

	}
}
