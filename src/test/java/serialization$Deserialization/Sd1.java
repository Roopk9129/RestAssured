package serialization$Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClasses.ArrayOfObject_Serialization;
import PojoClasses.Des;

public class Sd1 {
	@Test
	public void serialization() throws Throwable, JsonMappingException, IOException {
		ArrayOfObject_Serialization ao = new ArrayOfObject_Serialization("Black", "#f00");
		ObjectMapper map = new ObjectMapper();
		Random an = new Random();
		int ranint = an.nextInt();
		map.writeValue(new File("./OutputFolder/opt_" + ranint + ".json"), ao);
		map.writerWithDefaultPrettyPrinter().writeValue(new File("./OutputFolder/opt_" + ranint + ".json"), ao);

	}
	
	@Test
	public void deSerialization() throws Throwable{
		ObjectMapper map = new ObjectMapper();
		Des datas = map.readValue(new File(".\\src\\main\\resources\\Jsons\\Input.json"), Des.class);
		List<Object> color = datas.getColor();
		
		for(Object d:color) {
			System.out.println(d.toString());
				
		}
		
	}
	
	

}
