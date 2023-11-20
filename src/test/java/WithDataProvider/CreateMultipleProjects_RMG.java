package WithDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PojoClasses.PojoClassForProjectCreation_RMG;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.Random;
public class CreateMultipleProjects_RMG {
	@Test(dataProvider = "data")
	public void createMultipleProjects(String createdBy, String ProjectName, String Status, int teamsize) {
		baseURI="http://rmgtestingserver";
		port=8084;
		int ran = new Random().nextInt(1000);
		PojoClassForProjectCreation_RMG pojo = new PojoClassForProjectCreation_RMG(createdBy + ran, ProjectName + ran,
				Status, teamsize);
		given().body(pojo).contentType(ContentType.JSON)
				.when().post("/addProject")
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[3][4];
		obj[0][0] = "Proj_";
		obj[0][1] = "Bell";
		obj[0][2] = "completed";
		obj[0][3] = 15;

		obj[1][0] = "Proj_";
		obj[1][1] = "samsung";
		obj[1][2] = "Created";
		obj[1][3] = 16;

		obj[2][0] = "Proj_";
		obj[2][1] = "samsung";
		obj[2][2] = "Created";
		obj[2][3] = 16;
		return obj;
	}
}
