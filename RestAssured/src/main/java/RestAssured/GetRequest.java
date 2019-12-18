//copy the static imports from google.
package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void assuredDemo() {

		String url = "https://reqres.in/api/users";
		RequestSpecification req = given().param("page", 2);

		Response res = req.get(url); // all the response including header and payload is there in Response class.

		int statusCode = res.getStatusCode();
		System.out.println("StatusCode is " + statusCode);
		Assert.assertEquals(statusCode, 200);

		String JsonFormatData = res.asString();
		System.out.println("Response Body is --" + JsonFormatData);

		Headers header = res.getHeaders();
		System.out.println("Response headers are --" + header);

	}
}
