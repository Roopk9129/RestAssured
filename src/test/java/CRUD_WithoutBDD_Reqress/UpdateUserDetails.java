package CRUD_WithoutBDD_Reqress;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUserDetails {
	@Test
	public void updateUserDetails() {
		JSONObject jobj = new JSONObject();
		jobj.put("name", "roop");
		jobj.put("job", "res");
		
		RequestSpecification put = RestAssured.given();
		put.body(jobj);
		put.contentType(ContentType.JSON);
		
		 Response res = put.put("https://reqres.in/api/users/2");
		System.out.println(res.prettyPeek());
		int scode = res.statusCode();
		Assert.assertEquals(200, scode);
		System.out.println("As expected");
	}

}
