package Tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceholder {

   /* Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
    donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
            edin
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
    donen response’un status code’unun 200 oldugunu ve “title” degerinin
“optio dolor molestias sit” oldugunu test edin

3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
    gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
null oldugunu test edin  ====>>>>SORUNUN CEVABI 18.class'da

    */
    @Test
    public void test01(){

        // 1_   end-point  ve request body hazirlama
        specJsonPlaceHolder.pathParam("pp1","posts");

        // 2- (varsa)  Expected data hazirlama

        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given()
                .when().spec(specJsonPlaceHolder)
                .get("/{pp1}");

        // 4- Assertion
              //basit assertion ile assert edelim

        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));





    }
    @Test
    public void test02(){
        // 1_   end-point  ve request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        // 2- (varsa)  Expected data hazirlama
        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given().when().spec(specJsonPlaceHolder)
                .get("/{pp1}/{pp2}");

        // 4- Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("optio dolor molestias sit"));


    }





}
