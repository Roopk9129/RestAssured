package responseValidationAndJSONPath;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseValid_RMG {
	@Test
	public void staticResponseValid(){
		baseURI="http://rmgtestingserver";
		port=8084;
		String expData="TY_PROJ_1342";
		
		Response resp = when()
		.get("/projects");
		
		String actData = resp.jsonPath().get("[3].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("Data Verified");
		
		resp.then().assertThat().time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS).log().all();
	
		
	}

}
