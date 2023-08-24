package Serial_Deserail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.pojoclass.Complex_Paring_PojoClass;


public class Serial_Deserial_Complex_Json {

	@Test
	
	public void Complex() throws JsonGenerationException, JsonMappingException, IOException {
		
		String []name= {"nms","madhu"};
		int []cont= {123456,789456};
		
		Complex_Paring_PojoClass comp=new Complex_Paring_PojoClass(name,"abc@gmail.com",cont, 25);
	
		ObjectMapper map=new ObjectMapper();
		
		map.writerWithDefaultPrettyPrinter().writeValue(new File("./complex.json"), comp);
		
		Complex_Paring_PojoClass data = map.readValue(new File("./complex.json"),Complex_Paring_PojoClass.class);

		System.out.println(Arrays.toString(data.getName()));
		System.out.println(data.getEmail());
		System.out.println(Arrays.toString(data.getContact()));
		System.out.println(data.getAge());
		
		
	}
}
