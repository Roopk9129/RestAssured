package CRUD_WithBDDApproach_Reqress;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUser {
	@Test
	public void updateUser() {
		baseURI ="https://reqres.in/";
		
		when()
		.delete("api/users/2")
		.then()
		.assertThat()
		.statusCode(204)
		.log()
		.all();
		
	}

}
