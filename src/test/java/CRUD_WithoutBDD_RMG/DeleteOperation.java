package CRUD_WithoutBDD_RMG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteOperation {
	@Test
	public void deleteOperation() {
		Response del = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_1244");
		System.out.println(del.prettyPeek());
	}

}
