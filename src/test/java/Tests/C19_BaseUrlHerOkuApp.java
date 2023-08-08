package Tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerOkuApp extends BaseUrlHerOkuApp {
    /*
    1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 12 ADET booking oldugunu test
edin
     */
    @Test
    public void test01(){
        // 1_   end-point  ve request body hazirlama
        specHerOkuApp.pathParam("pp1","booking");


        // 2- (varsa)  Expected data hazirlama

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given()
                .when().spec(specHerOkuApp)
                .get("/{pp1}");

        // 4- Assertion
        JsonPath responseJsonPath=response.jsonPath();//daha kolaylik icin
        System.out.println(responseJsonPath.getList("bookingId").size());//kac element oldugunu test ettik
                                                               //gerekli degil fakat sitede surekli size degisiyor

        response.then()
                .assertThat()
                .statusCode(200)
                .body("booking", Matchers.hasSize(3293));// sayi surekli degisiyor


    }

}
