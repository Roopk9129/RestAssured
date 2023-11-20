package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameter {
	@Test
	public void formParameter() {
	
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.formParam("createdBy", "abcd_1236")
		.formParam("projectName", "proj_111")
		.formParam("status", "on going")
		.formParam("teamSize", 10)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

	



}
