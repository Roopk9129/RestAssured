package CRUD_WithoutBDD_RMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutOperation {
	@Test
	public void putOperation() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Test_");
		jobj.put("projectName", "Project_Test_");
		jobj.put("status", "not comp");
		jobj.put("teamSize", "11");

		RequestSpecification putReq = RestAssured.given();
		putReq.body(jobj);
		putReq.contentType(ContentType.JSON);

		Response put = putReq.put("http://rmgtestingserver:8084/projects/TY_PROJ_1243");
		System.out.println(put.prettyPeek());
	}
}
