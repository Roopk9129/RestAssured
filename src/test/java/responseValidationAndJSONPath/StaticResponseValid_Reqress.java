package responseValidationAndJSONPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValid_Reqress {
	@Test
	public void staticResponseValid_Reqress() {
		baseURI = "https://reqres.in";
		int expected = 9;

		Response resp = when().get("/api/users?page=2");

		int actData = resp.jsonPath().get("data[2].id");
		Assert.assertEquals(actData, expected);
		System.out.println("Data is verified");
		resp.then().log().all();

	}
}
