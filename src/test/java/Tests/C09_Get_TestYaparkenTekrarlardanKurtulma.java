package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;   //Matchers.* yazarsak matcher classindaki tum statik methodlari import et

public class C09_Get_TestYaparkenTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "totalprice“in, 1000 den kucuk oldugu,
ve "depositpaid“in, false,
ve "additionalneeds“in, bos birakilmadigini
oldugunu test edin
     */

    @Test()
    public void test09() {
        // 1_ request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- (varsa)  Expected (body) data hazirlama

        // 3- Request gonderip donen reponse'i kaydet
        Response response = given().when().get(url);


        // 4- Assertion
        response.prettyPrint();  //bu satiri gormek icin yazdiriyorum

/*
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Sally"))
                .body("lastname",Matchers.equalTo("Ericsson"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(false))
                .body("additionalneeds",Matchers.nullValue());

 */
        //ikinci yontem; tekrardan kurtulma yontemi
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary"),
                "lastname", equalTo("Smith"),
                "totalprice", lessThan(1000),
                "depositpaid", equalTo(true),
                "additionalneeds" ,nullValue());





    }
}



