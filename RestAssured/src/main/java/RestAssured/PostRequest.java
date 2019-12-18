package RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@SuppressWarnings("unchecked")
	@Test
	public void postRequest() {

		String url = "https://reqres.in/api/users";

		RequestSpecification req = given();

		req.header("Content-Type", "application/json");

		JSONObject obj = new JSONObject();
		obj.put("name", "Anwesha");
		obj.put("job", "Manager");
		obj.put("id", "101");

		String JsonData = obj.toJSONString();
		req.body(JsonData);

		Response res = req.request(Method.POST, url);

		int statusCode = res.getStatusCode();
		System.out.println("StatusCode is " + statusCode);
		Assert.assertEquals(statusCode, 201);

		String JsonFormatData = res.asString();
		System.out.println("Response Body is --" + JsonFormatData);

		Headers header = res.getHeaders();
		System.out.println("Response headers are --" + header);

	}

}
