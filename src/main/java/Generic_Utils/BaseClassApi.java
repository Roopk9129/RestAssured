package Generic_Utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassApi {
	public DatabaseUtility du = new DatabaseUtility();
	public Java_Utils ju = new Java_Utils();
	public RestAssuredLibrary ru = new RestAssuredLibrary();
	public RequestSpecification reqS;
	public ResponseSpecification resS;
	
	

	@BeforeSuite
	public void BS() throws Throwable {
		du.connectToDB();
		
		reqS = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		resS = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	@AfterSuite
	public void AS() throws Throwable {
		du.closeDB();
	}
}
