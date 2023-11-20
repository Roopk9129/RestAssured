package UsingHashMap_Reqress;

import java.util.LinkedHashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUser {
	@Test
	public void createUser() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		baseURI ="https://reqres.in";
		int ranInt = new Random().nextInt(1000);
		map.put("name", "roop"+ranInt);
		map.put("job", "TL");

		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
