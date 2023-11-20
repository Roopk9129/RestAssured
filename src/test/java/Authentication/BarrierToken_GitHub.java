package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BarrierToken_GitHub {
	@Test
	public void barrierToken_GitHub() {
		baseURI = "https://api.github.com";

		JSONObject jobj = new JSONObject();
		jobj.put("name", "RestAssuredTest1");
		jobj.put("description", "RestAssuredTestDes1");
		
		given().auth().oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")
		.then()
		.assertThat()
		.statusCode(201)
		.log()	
		.all();
		

	}

}
