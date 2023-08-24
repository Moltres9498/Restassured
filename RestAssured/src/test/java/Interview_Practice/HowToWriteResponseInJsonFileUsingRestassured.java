package Interview_Practice;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class HowToWriteResponseInJsonFileUsingRestassured {

	@Test

	public void GetUser() throws IOException {

		baseURI="https://reqres.in/";

		//		Response resp = given()                        		//1st way
		//		.get("api/users/2");
		//		String data = resp.getBody().asPrettyString();
		//		FileWriter write=new FileWriter("./response.json");
		//		write.write(data);
		//		write.close();
		//		System.out.println("Response noted to file");


		//		Response resp = given()                         // 2nd way
		//		.get("api/users/2");
		//		String data = resp.getBody().asPrettyString();
		//		byte[] respbyte = data.getBytes();
		//		File dest = new File("./data.json");
		//		Files.write(respbyte, dest);


		//		Response resp = given()                         // 3rd way---not preferred--sometimes it won't support in restassured
		//				.get("api/users/2");
		//		InputStream data = resp.asInputStream();
		//		byte[] respbyte = new byte[data.available()];
		//		data.read(respbyte);
		//		File dest = new File("./JSON_by_byte.json");
		//		Files.write(respbyte, dest);


		Response resp = given()                         // 2nd way-- optimised--way
				.get("api/users/2");
		 byte[] data = resp.asByteArray();
		 File dest = new File("./resp-to-file-optway.json");
		 Files.write(data, dest);

	}
}