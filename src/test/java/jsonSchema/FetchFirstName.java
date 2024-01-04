package jsonSchema;

import static io.restassured.RestAssured.when;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FetchFirstName {

	@Test
	public void fetchFirstName() {
		Response resp = when().get("https://reqres.in/api/users?page=2");
		List<String> key = resp.jsonPath().get("data.email");
		List<String> value = resp.jsonPath().get("data.first_name");
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < key.size(); i++) {
			map.put(key.get(i), value.get(i));
		}
		System.out.println("Enter the Key");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		for (java.util.Map.Entry<String, String> m : map.entrySet()) {
			if (m.getKey().equalsIgnoreCase(s)) {
				System.out.println(m.getValue());
			}
		}
	}
}