package RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void putRequest() {

		String url = "https://reqres.in/api/users/";

		RequestSpecification req = given();

		req.header("Content-Type", "application/json");

		JSONObject obj = new JSONObject();
		obj.put("name", "Anwesha");
		obj.put("job", "Branch Manager");
		obj.put("id", "101");

		String JsonString = obj.toJSONString();
		req.body(JsonString);

		Response res = req.put(url);

		int statusCode = res.getStatusCode();
		System.out.println("StatusCode is " + statusCode);
		Assert.assertEquals(statusCode, 200);

		String JsonFormatData = res.asString();
		System.out.println("Response Body is --" + JsonFormatData);

		Headers header = res.getHeaders();
		System.out.println("Response headers are --" + header);
	}
}
