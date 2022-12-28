package rest_testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
public class trello {
public String url = "https://api.trello.com";

@Test

public void tc1() {
//	JSONObject js = new JSONObject();
	RestAssured.baseURI=url;
	given().queryParam("name","shinde").queryParam("key","412b4856d9045bc07a838e98bc330d50")
	.queryParam("token","ba2fd875ed28d0e324fd2b5616e2eedb14dae68b1529516f39b7a30a6249aa28")
	.when().contentType(ContentType.JSON).accept(ContentType.JSON).
	post("/1/boards/").then().log().all();
	
}

}
