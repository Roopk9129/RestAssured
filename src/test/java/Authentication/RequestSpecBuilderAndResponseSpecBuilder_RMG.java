package Authentication;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClasses.PojoClassForProjectCreation_RMG;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecBuilderAndResponseSpecBuilder_RMG {
	@Test
	public void requestSpecBuilderAndResponseSpecBuilder() {
		int ran = new Random().nextInt(1000);
		PojoClassForProjectCreation_RMG pojo = new PojoClassForProjectCreation_RMG("tyss_" + ran, "proj_" + ran, "ongoing", 10);

		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		ResponseSpecification res = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON).expectStatusCode(201)
				.build();
		
		given().spec(req).body(pojo)
		.when().post("/addProject")
		.then().spec(res).log().all();
	}

}
