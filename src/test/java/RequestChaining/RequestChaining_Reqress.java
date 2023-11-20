package RequestChaining;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RequestChaining_Reqress {
	@Test
	public void requestChaining_Reqress() {
		baseURI="https://reqres.in";
		
		Response resp = when()
		.get("/api/users?page=2");
		
		resp.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		int id = resp.jsonPath().get("data[1].id");
		System.out.println(id);
		
		given().pathParam("uid", id)
		.get("/api/users/{uid}")
		.then().assertThat().statusCode(200).log().all();
	}
}
