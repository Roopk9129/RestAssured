package UsingPOJOClass_RMG;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClasses.PojoClassForProjectCreation_RMG;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void createProject() {
		int ran = new Random().nextInt(1000);
		baseURI="http://rmgtestingserver";
		port=8084;

		PojoClassForProjectCreation_RMG pojo= new PojoClassForProjectCreation_RMG("Test_Name_"+ran, "project_Name_"+ran, "On going", 16);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
