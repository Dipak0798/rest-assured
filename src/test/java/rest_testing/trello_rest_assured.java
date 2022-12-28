package rest_testing;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class trello_rest_assured {
	public static String baseurl="https://api.trello.com";
	public String id;
	@Test()
	public void createBoard()
	{
		RestAssured.baseURI=baseurl;
	Response response=given().queryParam("name", "Dipak")
		.queryParam("key", "412b4856d9045bc07a838e98bc330d50")
		.queryParam("token", "ba2fd875ed28d0e324fd2b5616e2eedb14dae68b1529516f39b7a30a6249aa28")
		.header("Content-Type", "application/json")
		.when()
		.post("/1/boards/")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
		JsonPath js= new JsonPath(jsonresponse);
		
		id = js.get("id");
		System.out.println(id);		
	}
	
	}