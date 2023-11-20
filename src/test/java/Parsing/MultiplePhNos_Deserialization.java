package Parsing;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import PojoClasses.PojoClassFor_Serialization_Deserialization_Array;

public class MultiplePhNos_Deserialization {
	@Test
	public void multiplePhNos_Deserialization() throws Throwable, JsonMappingException, IOException {
		ObjectMapper omap = new ObjectMapper();

		PojoClassFor_Serialization_Deserialization_Array data = omap.readValue(new File("./Serial_arr.json"),
				PojoClassFor_Serialization_Deserialization_Array.class);
		System.out.println(data.getEid());
		System.out.println(data.getEname());
		System.out.println(data.getPh()[0]);
		System.out.println(data.getPh()[1]);
	}
}
