package CRUD_WithoutBDD_RMG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	@Test
	public void getSingleProject1() {
		Response getSingProj = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_059");
		System.out.println(getSingProj.prettyPrint());
		
	}

}
