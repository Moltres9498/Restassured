package Serial_Deserail;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.pojoclass.Serialization_PojoClass;

public class Serial_Deserial_Basic_json {

	@Test

	public void serial() throws JsonGenerationException, JsonMappingException, IOException {

		Serialization_PojoClass ser=new Serialization_PojoClass("NMS","abc@gmail.com", 25, 1234567891);   //Serialization

		ObjectMapper map=new ObjectMapper();

		map.writerWithDefaultPrettyPrinter().writeValue(new File("./serial.json"), ser);   //Serialization

		Serialization_PojoClass data = map.readValue(new File("./serial.json"),Serialization_PojoClass.class);  //Deserialization

		System.out.println(data.getName());  //Deserialization
		System.out.println(data.getEmail());  //Deserialization
		System.out.println(data.getAge());    //Deserialization
		System.out.println(data.getContact());   //Deserialization
	}
}