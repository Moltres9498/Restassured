package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.restassured.genric.JavaLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class RegisterAsAShopper {

	@SuppressWarnings("unchecked")
	@Test
	
	public void Register() {
		
		baseURI="https://www.shoppersstack.com/shopping";
		JavaLibrary jlib=new JavaLibrary();
		String pass="aa"+jlib.GetRandomNumber()+"vd";
		
		JSONObject json=new JSONObject();																				//post-register as a shopper
		json.put("city", "Hydrabad");
		json.put("country", "Indonesia");
		json.put("email", "abc56"+jlib.GetRandomNumber()+"69@gmail.com");
		json.put("firstName", "Levi");
		json.put("gender", "MALE");
		json.put("lastName", "ackermann");
		json.put("password", pass);
		json.put("phone", 9498929796l);
		json.put("state", "telengana");
		json.put("zoneId", "ALPHA");
		
		Response resp = given()
		.body(json)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/shoppers");
		
		Object em = resp.jsonPath().get("data.email");
		Object role = resp.jsonPath().get("data.role");
		
		given().then().log().all();
		
		
		
		JSONObject json1=new JSONObject();												// login as a shopper
		json1.put("email", em);
		json1.put("password", pass);
		json1.put("role", role);
		
		Response resp1 = given()
		.body(json1)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/users/login");

		
				
		given()																							// find shopper data by shopper id
		.pathParam("id", ""+resp1.jsonPath().get("data.userId")+"")
		.auth().oauth2(""+resp1.jsonPath().get("data.jwtToken")+"")
		
		.when()
		.get("/shoppers/{id}");

		given().then().log().all();

		
		
		JSONObject jobj=new JSONObject();											//Update the shopper details
		jobj.put("firstName","Gojo");
		jobj.put("lastName","satoru");
		jobj.put("city", "Bengaluru");
		jobj.put("country", "India");
		jobj.put("state", "karnataka");
		jobj.put("phone", 9498929796l);
		
		given()																							
		.pathParam("sid",""+resp1.jsonPath().get("data.userId")+"")
		.auth().oauth2(""+resp1.jsonPath().get("data.jwtToken")+"")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.patch("/shoppers/{sid}");
		
		given().then().log().all();
		
		

		Response resp2 = given()																						//Generates URL for forgot password
		.header("email", em)
		.header("role", role)
		.header("verifyUrl", "https://verifyurl.in/check")
		.contentType(ContentType.JSON)
		
		.when()
		.post("/users/forgot-password");
		
		String tok=resp2.jsonPath().get("data.token");
		System.out.println(tok);

		given().then().log().all();
				
		

		given()																												//Set user password
		.header("password", pass)
		.queryParam("token", tok)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/users/verify-account?token")
		
		.then().log().all();
		
		
//		JSONObject jsonobj=new JSONObject();													//Resets the password
//		jsonobj.put("password", "aabb13@8$");
//		
//		given()
//		.header("token", tok)
//		.body(jsonobj)
//		.contentType(ContentType.JSON)
//		
//		.when()
//		.post("/users/reset-password")
//		
//		.then().log().all();
	}
}
