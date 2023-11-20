package Authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BasicAuth_RMG {
	@Test
	public void  basicAuth_RMG(){
		baseURI="http://rmgtestingserver/";
		port=8084;
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		.then()
		.assertThat()
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.statusCode(202)
		.log().all();
		
	}

}
