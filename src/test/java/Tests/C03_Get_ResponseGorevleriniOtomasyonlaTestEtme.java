package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseGorevleriniOtomasyonlaTestEtme {
    @Test
    public void test03(){
        // 1_ request body ve end-point hazirlama
        String url="https://restful-booker.herokuapp.com/booking/121";

        // 2- (varsa)  Expected data hazirlama

        // 3- Request gonderip donen reponse'i kaydet
        Response response=given().when().get(url);

        // 4- Assertion
        response
                .then()
                .assertThat()   // bunlari yani asagidakileri test et
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server" ,"Cowboy")
                .statusLine("HTTP/1.1 200 OK");




    }
}
