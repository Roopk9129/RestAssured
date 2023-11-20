package Parsing;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import PojoClasses.PojoClassFor_Serialization_Deserialization_Array;

public class MultiplePhNos {
	@Test
	public void multiplePhNos() throws Throwable, JsonMappingException, IOException{
		int[] ph= {9999,8888};
		PojoClassFor_Serialization_Deserialization_Array pojo = new PojoClassFor_Serialization_Deserialization_Array("Roop","ty",ph);
		ObjectMapper omap = new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./Serial_arr.json"), pojo);
		
	}
}
