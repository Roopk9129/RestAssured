package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AccessApisUsingToken_Coops {
	@Test
	public void accessApisUsingToken_Coops() {
		baseURI="http://coop.apps.symfonycasts.com";
		Response resp = given()
		.formParam("client_id", "roop")
		.formParam("client_secret", "c31c3bd3068490e48cd93ebabedeaebd")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		.when()
		.post("/token");
		resp.then().assertThat().statusCode(200)
		.log().all();
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		given().auth().oauth2(token).pathParam("id",4732)
		.when().post("/api/{id}/eggs-count")
		.then().log().all();
	}
}
