package Tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlDummyRestapi2 extends BaseUrlJsonPlaceholder {
    /*
    3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
    gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
null oldugunu test edin
     */

    @Test
    public void test01(){
        // 1_   end-point  ve request body hazirlamas
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",50); //iki parametre var
                                                           //body olusturmuyorum cunku var olan bir seyi silcem


        // 2- (varsa)  Expected data hazirlama
                                 //bekledigim bir sey yok

        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given()
                .when().spec(specJsonPlaceHolder)
                .delete("/{pp1}/{pp2}");   //silecegim parametrelerin isimlerini yazdim,yukarda 19.satirda ne olduklarini belirttik


        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.nullValue());// neden title i yazdim?
                                                 //cunku zaten silenen bir sey oldugu icin ne yazacagim onemli degil

    }
}
