package CRUD_WithBDDApproach_Reqress;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class GetAllUsers {
	@Test
	public void getAllUsers() {
		baseURI="https://reqres.in/";
				
		when()
		.get("/api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
