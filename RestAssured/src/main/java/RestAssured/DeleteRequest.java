package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void deleteRequest() {

		String url = "https://reqres.in/api/users/2";

		RequestSpecification req = given();

		Response res = req.delete(url);

		int statusCode = res.getStatusCode();
		System.out.println("StatusCode is " + statusCode);
		Assert.assertEquals(statusCode, 204);

		String JsonFormatData = res.asString();
		System.out.println("Response Body is --" + JsonFormatData);

		Headers header = res.getHeaders();
		System.out.println("Response headers are --" + header);
	}
}
