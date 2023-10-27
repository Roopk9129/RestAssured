package CRUD_WithBDDApproach_RMG;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjects {
	@Test
	public void getAllProjects() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
	get("/projects")
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
		
	}

}
