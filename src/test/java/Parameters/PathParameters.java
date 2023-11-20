package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameters {
	@Test
	public void pathParameters() {
		baseURI = "http://rmgtestingserver/";
		port = 8084;
		given().pathParam("pid", "TY_PROJ_1650")

				.when().get("/projects/{pid}")

				.then().log().all();

	}
}
