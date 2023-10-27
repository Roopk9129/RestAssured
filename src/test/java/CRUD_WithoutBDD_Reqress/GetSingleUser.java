package CRUD_WithoutBDD_Reqress;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUser {
	@Test
	public void getSingleUser() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.prettyPeek());
		int scode = res.statusCode();
		if (200 == scode) {
			System.out.println("As Expected");

		} else {
			System.out.println("Failed");
		}

	}

}
