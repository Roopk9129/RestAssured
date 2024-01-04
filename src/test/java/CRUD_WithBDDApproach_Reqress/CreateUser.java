package CRUD_WithBDDApproach_Reqress;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateUser {
	@Test
	public void createUser() {
		JSONObject jobj = new JSONObject();
		baseURI = "https://reqres.in";
		
		jobj.put("name", "roop");
		jobj.put("job", "AM");
	
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
		
		
	}

}
