package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponceBilgileriAssertion {

    @Test
    public void test06(){
        // 1_ request body ve end-point hazirlama
        String url="https://restful-booker.herokuapp.com/booking/1360";

        JSONObject requestBody=new JSONObject();

        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",5);
        requestBody.put("id",44);

        // 2- (varsa)  Expected (body) data hazirlama

        // 3- Request gonderip donen reponse'i kaydet
        Response response=given().contentType(ContentType.JSON)  //artik buraya bir body eklememiz lazim ve turunu de belirtmemiz lazim orng:JASON veya HTML gibi
                .when().body(requestBody.toString())
                .put(url);

        // 4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server" ,"cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
