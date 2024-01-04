package responseValidationAndJSONPath;

import static io.restassured.RestAssured.*;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class DynamicResponseValidation_Reqress {
	@Test
	public void dynamicResponseValidation_Reqress() {
		baseURI = "https://reqres.in";
		String Expected = "lindsay.ferguson@reqres.in";
		Response resp = when().get("/api/users?page=2");
		boolean flag = false;
		List<String> act = resp.jsonPath().get("data.email");
		for (String str : act) {
			if (str.equalsIgnoreCase(Expected)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data verified");
		resp.then().log().all();
	}
	@Test
	public void stringProg() {
		String str="abc123";
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
//				Integer.parseInt(str.charAt(i));
				
			}
			
		}
		
	}
}

