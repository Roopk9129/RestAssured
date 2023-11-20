package CRUD_WithBDDApproach_Reqress;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateUser {
	@Test
	public void updateUser() {
		baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("name", "roop");
		jobj.put("job", "AM");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
	

}
