package RequestChaining;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RequestChaining_RMG {
	@Test
	public void requestChaining_RMG() {
		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		baseURI="http://rmgtestingserver";
		port=8084;
		int ranInt = new Random().nextInt(1000);
		map.put("createdBy", "Pr_10_1"+ranInt);
		map.put("projectName", "PrN_10_1"+ranInt);
		map.put("status", "Done");
		map.put("teamSize", 6);
		Response resp = given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		resp.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
		String id = resp.jsonPath().get("projectId");
		System.out.println(id);
		
		given().pathParam("pid", id).when()
		.get("/projects/{pid}")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS).log().all();	
	}
}
