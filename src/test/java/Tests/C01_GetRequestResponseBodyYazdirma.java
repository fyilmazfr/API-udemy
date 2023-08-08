package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequestResponseBodyYazdirma {
    @Test
    public void get01(){
//https://restful-booker.herokuapp.com/booking/1360 url'ine

        // 1_ request body ve end-point hazirlama
        String url="https://restful-booker.herokuapp.com/booking/1360";


        // 2- (varsa)  Expected data hazirlama  //soruda benden bunu istememis ve pass geciyoruz

        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given().when().get(url); // serverdan gelen cevabi response objesine atip bize verecek
        response.prettyPrint();    //bu response'iin body'sini gozumuzle de gormek icin


        // 4- Assertion
    }
}
