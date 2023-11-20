package UsingHashMap_RMG;

import java.util.LinkedHashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void createProject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		int ran = new Random().nextInt(1000);
		
		map.put("createdBy", "Test_Name_"+ran);
		map.put("projectName", "project_Name_"+ran);
		map.put("status", "On going");
		map.put("teamSize", 15);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		
	}

}
