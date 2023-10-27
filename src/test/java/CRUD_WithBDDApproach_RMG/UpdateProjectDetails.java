package CRUD_WithBDDApproach_RMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateProjectDetails {
	@Test
	public void updateProjectDetails() {
		JSONObject jobj = new JSONObject();
		int ranInt = new Random().nextInt(1000);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		jobj.put("createdBy", "Test_" + ranInt);
		jobj.put("projectName", "Project_Test_" + ranInt);
		jobj.put("status", "pending");
		jobj.put("teamSize", 15);

		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/TY_PROJ_1450")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
