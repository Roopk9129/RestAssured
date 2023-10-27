package CRUD_WithoutBDD_Reqress;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateReq {
	@Test
	public void createReq() {
		JSONObject jobj = new JSONObject();

		jobj.put("name", "morpheus");
		jobj.put("job", "leader");

		RequestSpecification postreq = RestAssured.given();
		postreq.body(jobj);
		postreq.contentType(ContentType.JSON);

		Response resp = postreq.post("https://reqres.in/api/users");
		System.out.println(resp.asPrettyString());
		int code = resp.getStatusCode();
		Assert.assertEquals(201, code);
		System.out.println("passed");

	}

}
