package Parsing;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClasses.PojoClassFor_Serialization_Deserialization;

public class Serialization {
	@Test
	public void serialization() throws Throwable {
		ObjectMapper omap = new ObjectMapper();
		PojoClassFor_Serialization_Deserialization poj = new PojoClassFor_Serialization_Deserialization("Roop",998877665,27);
		omap.writeValue(new File("./roop.json"), poj);
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./Roop1.json"), poj);
	}
}
