package Interview_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.restassured.genric.JavaLibrary;
import com.restassured.pojoclass.RMG_YANTRA_PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Response_Header_Validation {

	@Test

	public void Validation() {

		baseURI="http://rmgtestingserver";
		port=8084;

		String Expected_StatusLine="HTTP/1.1 201 ";
		String Expected_Vary="Access-Control-Request-Headers";
		String Expected_ContentType="application/json";
		String Expected_Pragma="no-cache";
		String Expected_Connection="keep-alive";

		JavaLibrary jlib=new JavaLibrary();

		RMG_YANTRA_PojoClass rmg=new RMG_YANTRA_PojoClass("nms","estron "+jlib.GetRandomNumber()+"","done",5);

		Response resp = given()
				.body(rmg)
				.contentType(ContentType.JSON)

				.when()
				.post("/addProject");

		System.out.println(resp.getHeaders());
		System.out.println();
		System.out.println();
		System.out.println();

		String statusline=resp.statusLine();
		System.out.println("Its verified--->"+statusline);
		Assert.assertEquals(statusline, Expected_StatusLine);

		String vary=resp.getHeader("Vary");
		System.out.println("Its verified--->"+vary);
		Assert.assertEquals(vary,Expected_Vary);

		String content=resp.getHeader("Content-Type");
		System.out.println("Its verified--->"+content);
		Assert.assertEquals(content, Expected_ContentType);

		String pragma=resp.getHeader("Pragma");
		System.out.println("Its verified--->"+pragma);
		Assert.assertEquals(pragma,Expected_Pragma);

		String conn=resp.getHeader("Connection");
		System.out.println("Its verified--->"+conn);
		Assert.assertEquals(conn,Expected_Connection);	
	}
}