package Generic_Utils;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	public String getJSOnData(Response resp, String path) {
		return resp.jsonPath().get(path);
	}
}
