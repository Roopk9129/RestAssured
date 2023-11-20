package Parsing;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClasses.PojoClassFor_Serialization_Deserialization;

public class Deserialization {
	@Test
	public void deserialization() throws Throwable, JsonMappingException, IOException {
		ObjectMapper omap = new ObjectMapper();
		PojoClassFor_Serialization_Deserialization data = omap.readValue(new File("./Roop1.json"),
				PojoClassFor_Serialization_Deserialization.class);
		System.out.println(data.getEname());
		System.out.println(data.getAge());
		System.out.println(data.getPhoneno());
	}
}
