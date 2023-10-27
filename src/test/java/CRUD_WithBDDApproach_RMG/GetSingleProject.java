package CRUD_WithBDDApproach_RMG;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingleProject {
	@Test
	public void getSingleProject() {
		baseURI ="http://rmgtestingserver:8084";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_1340")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
