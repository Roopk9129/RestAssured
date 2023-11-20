package Miscellious_Validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Validation1 {
	@Test
	public void validation1() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		String expected_statusLine="HTTP/1.1 200 ";
		String expected_vary="Access-Control-Request-Headers";
		String expected_contentType="application/json";
		String expected_pragma="no-cache";
		String expected_Connection="keep-alive";
		
		Response resp = when()
		.get("/projects/TY_PROJ_2188");
		
		String ActualSL = resp.statusLine();
		System.out.println(ActualSL);
		Assert.assertEquals(ActualSL, expected_statusLine);
		
		Headers hea = resp.getHeaders();
		System.out.println(hea);

		
		String actual_CT = resp.getHeader("Content-Type");
		Assert.assertEquals(actual_CT, expected_contentType);
		
		
		String actual_pragma = resp.getHeader("Pragma");
		Assert.assertEquals(actual_pragma, expected_pragma);
		
		String actual_vary = resp.getHeader("Vary");
		Assert.assertEquals(actual_vary, expected_vary);
		
		String aconn = resp.getHeader("Connection");
		Assert.assertEquals(aconn, expected_Connection);
		
		
		
		
	}

}
