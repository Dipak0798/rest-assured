package rest_testing;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class rest_assured {

	public String URL="https://reqres.in/api/users?page=2";
	@Test(enabled=false)
	public void get_tc1() {
		Response rep=RestAssured.get(URL);
		int actual=rep.statusCode();
		Assert.assertEquals(actual,200);
	}
	@Test(enabled=true)
	public void get_tc2() {
		given().get(URL).then().statusCode(200).log().all();
		given().get(URL).then().statusCode(200).body("data.first_name", hasItems("Michael"));
		JSONObject js= new JSONObject();
//		js.put("name", "Dipak");
//		js.put("job", "tester");
		
	}
}
