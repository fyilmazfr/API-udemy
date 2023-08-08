package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {//post method'unda bir body gondermemiz gerekiyor
                                       //post yeni bir kayit olusturma demek

    @Test
    public void test07() {
        // 1_ request body ve end-point hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API");
        requestBody.put("body", "API ogrenmek ne guzel");
        requestBody.put("userId", 10);

        // 2- (varsa)  Expected (body) data hazirlama

        // 3- Request gonderip donen reponse'i kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);


        // 4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))    //100 den kucuk oldugunu test ettik
                .body("body",Matchers.containsString("API")); // API kelimesi varmi icinde dedik


    }
}
