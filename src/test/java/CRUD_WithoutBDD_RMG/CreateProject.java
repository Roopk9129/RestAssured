package CRUD_WithoutBDD_RMG;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProject() {
		JSONObject jobj = new JSONObject();
		int ranInt = new Random().nextInt(1000);
		
		jobj.put("createdBy", "Test_" + ranInt);
		jobj.put("projectName", "Project_Test_" + ranInt);
		jobj.put("status", "Completed");
		jobj.put("teamSize", "11");

		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);

		Response resp = req.post("http://rmgtestingserver:8084/addProject");
//		System.out.println(resp.asString());
//		System.out.println(resp.asPrettyString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.contentType());

	}

}
