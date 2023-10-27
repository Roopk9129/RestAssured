package CRUD_WithoutBDD_Reqress;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetListOfUsers {
	@Test
	public void getListOfUsers() {
		Response getres = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(getres.prettyPeek());
		int scode = getres.statusCode();
		if (200 == scode) {
			System.out.println("As Expected");

		} else {
			System.out.println("Failed");
		}

	}

}
