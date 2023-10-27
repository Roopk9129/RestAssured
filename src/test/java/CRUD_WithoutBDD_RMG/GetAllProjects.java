package CRUD_WithoutBDD_RMG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	@Test
	public void getAllProjects() {
		Response getreq = RestAssured.get("http://rmgtestingserver:8084/projects");
		System.out.println(getreq.asString());
	}

}
