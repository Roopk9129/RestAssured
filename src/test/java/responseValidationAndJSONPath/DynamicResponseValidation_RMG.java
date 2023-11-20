package responseValidationAndJSONPath;

import static io.restassured.RestAssured.*;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class DynamicResponseValidation_RMG {
	@Test
	public void dynamicResponseValidation() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		String expData = "TY_PROJ_1340";
		Response resp = when().get("/projects");
		boolean flag = false;
		List<String> pid = resp.jsonPath().get("projectId");
		for (String str : pid) {
			if (str.equalsIgnoreCase(expData)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data Verified");
		resp.then().log().all();
	}
}
