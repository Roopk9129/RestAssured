package CRUD_WithBDDApproach_RMG;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {
	@Test
	public void createProject() {
		JSONObject jobj = new JSONObject();
		int ranInt = new Random().nextInt(1000);
		baseURI = "http://rmgtestingserver";
		port = 8084;

		jobj.put("createdBy", "Test_" + ranInt);
		jobj.put("projectName", "Project_Test_" + ranInt);
		jobj.put("status", "Completed");
		jobj.put("teamSize", "11");

		given()
		.body(jobj)
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
