package BDDValidation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BDDValidation {
	/*
	 * @Test
	 * 
	 * public void validate() {
	 * given().when().get("http://jsonplaceholder.typicode.com/posts").then().
	 * statusCode(200); }
	 * 
	 * @Test public void showingPayload() {
	 * given().when().get("http://jsonplaceholder.typicode.com/posts").then().log().
	 * all(); }
	 * 
	 * @Test public void equalToFunction() {
	 * given().when().get("http://jsonplaceholder.typicode.com/posts/6").then().body
	 * ("id", equalTo(6)); }
	 * 
	 * @Test public void equalToFunctionPage() {
	 * given().when().get("http://reqres.in/api/users").then().body("page",
	 * equalTo(1)); }
	 */

	@Test
	public void equalToFunctionArrayObject() {
		given().when().get("http://reqres.in/api/users").then().body("data[4].id", equalTo(5));
	}
}
