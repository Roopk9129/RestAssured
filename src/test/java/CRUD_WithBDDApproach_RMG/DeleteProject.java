package CRUD_WithBDDApproach_RMG;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteProject {
	@Test
	public void deleteProject() {
		baseURI ="http://rmgtestingserver:8084";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_1497")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}

}
