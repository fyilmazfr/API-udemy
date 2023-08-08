package Tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerOkuApp {
    /*
    2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon
oldugunu test edecek bir GET request gonderdigimizde, donen response’un status
code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir booking oldugunu test
edin
     */
    @Test
    public void test01(){
        // 1_   end-point  ve request body hazirlama
        specHerOkuApp.pathParam("pp1","booking")
                .queryParams("firstname","Susan","lastname","Ericson");

        // 2- (varsa)  Expected data hazirlama

        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given()
                .when().spec(specHerOkuApp)
                .get("/{pp1}");

        // 4- Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(1));



    }
}
