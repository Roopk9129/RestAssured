package CRUD_WithBDDApproach_Reqress;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetSingleUser {
	@Test
	public void getSingleUser() {
		baseURI ="https://reqres.in/";
		when()
		.get("api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	
	
	
	
	}

}
