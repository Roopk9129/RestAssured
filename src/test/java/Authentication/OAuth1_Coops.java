package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class OAuth1_Coops {
	@Test
	public void oAuth1_Coops() {
		baseURI="http://coop.apps.symfonycasts.com";
		given()
		.formParam("client_id", "roop")
		.formParam("client_secret", "c31c3bd3068490e48cd93ebabedeaebd")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("/token")
		.then()
		.log().all();
	}
}
