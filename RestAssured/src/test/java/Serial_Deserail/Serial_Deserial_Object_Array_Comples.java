package Serial_Deserail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.pojoclass.Complex_Paring_PojoClass;
import com.restassured.pojoclass.Spouse_PojoClass;

public class Serial_Deserial_Object_Array_Comples {

	@Test
	
	public void ObjectArray() throws JsonGenerationException, JsonMappingException, IOException {
		
		Spouse_PojoClass sp=new Spouse_PojoClass("mikasa","female", 25);
		
		String[] name= {"madhu","nms"};
		int [] contact= {123456,456789};
		
		Complex_Paring_PojoClass comp=new Complex_Paring_PojoClass(name, "abc@gmail.com", contact, 25,sp);
		
		ObjectMapper map=new ObjectMapper();
		
		map.writerWithDefaultPrettyPrinter().writeValue(new File("./ObjectArray.json"),comp);
		
		Complex_Paring_PojoClass data = map.readValue(new File("./ObjectArray.json"),Complex_Paring_PojoClass.class);
		
		System.out.println(Arrays.toString(data.getName()));
		System.out.println(data.getEmail());
		System.out.println(Arrays.toString(data.getContact()));
		System.out.println(data.getAge());
		System.out.println(data.getSpo().getName());
		System.out.println(data.getSpo().getGender());
		System.out.println(data.getSpo().getAge());
	}
}