package End_To_End_Scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genric.baseclass.BaseClass_Restassured;
import com.restassured.genric.DataBaseUtility;
import com.restassured.genric.Icredentials;
import com.restassured.genric.Iendpoints;
import com.restassured.genric.JavaLibrary;

import com.restassured.genric.RestAssured_Library;
import com.restassured.pojoclass.RMG_YANTRA_PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Create_Proj__Validate_db extends BaseClass_Restassured {

	@Test
	
	public void CreateandValidate() throws Throwable {
		 JavaLibrary jlib=new JavaLibrary();
		 RestAssured_Library rest=new RestAssured_Library();
		 DataBaseUtility db=new DataBaseUtility();
		 
		baseURI=Icredentials.URL;
		
		
		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass("nms","estron "+jlib.GetRandomNumber()+"","done",5);

		Response resp = given()
		.body(rmg)
		.contentType(ContentType.JSON)

		.when()
		.post(Iendpoints.CreatePorject);

		String data = rest.getjsonresponse(resp, "projectId");
		System.out.println(data);
		
		String query="select* from project;";
		String actdata=db.executeQuerryAndVerify(query, 1, data);
		
		Assert.assertEquals(actdata,data);
		System.out.println("passed");
		
		resp.then()
		.log().all();
	}
}
