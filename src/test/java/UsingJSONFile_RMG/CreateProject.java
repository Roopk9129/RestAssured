package UsingJSONFile_RMG;

import java.io.File;

import javax.sound.sampled.Port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void createProject() {
		baseURI="http://rmgtestingserver/";
		port=8084;
		File file = new File("./src/test/resources/ProjectInput.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
