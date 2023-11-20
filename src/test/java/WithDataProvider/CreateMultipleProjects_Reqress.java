package WithDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClasses.PojoClassForProjectCreation_Reqress;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjects_Reqress {
	@Test(dataProvider = "data")
	public void createMultipleProjects_Reqress(String Name, String job) {
		baseURI="https://reqres.in/";

		PojoClassForProjectCreation_Reqress pojo = new PojoClassForProjectCreation_Reqress(Name, job);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users?page=2")
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}

	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "London";
		obj[0][1] = "UK";

		obj[1][0] = "Delhi";
		obj[1][1] = "India";

		return obj;
	}

}
