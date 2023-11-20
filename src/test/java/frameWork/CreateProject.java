package frameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utils.BaseClassApi;
import Generic_Utils.EndPoints;
import PojoClasses.PojoClassForProjectCreation_RMG;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class CreateProject extends BaseClassApi {
	@Test
	public void createProject() throws Throwable {
		PojoClassForProjectCreation_RMG pojo = new PojoClassForProjectCreation_RMG("cb_"+ju.randomIntegerNumber(1000), "pn_"+ju.randomIntegerNumber(1000), "on going", 20);
		
		Response resp = given().spec(reqS)
		.body(pojo)
		
		.when()
		.post(EndPoints.createProject);
		
		String expData = ru.getJSOnData(resp, "projectId");
		System.out.println(expData);
		
		String query ="SELECT * FROM PROJECT;";
		String actdata = du.executeQueryAndGetData(query, 1, expData);
		Assert.assertEquals(actdata,expData );
		System.out.println("Tast Case Pass");
		resp.then().log().all();
		
		
	}

}
