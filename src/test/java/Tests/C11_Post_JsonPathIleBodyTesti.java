package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_Post_JsonPathIleBodyTesti {
    /*
    {
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2023-01-10",
"checkout" : "2023-01-20"
},
"additionalneeds" : "wi-fi"
}

             donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2023-01-10
ve "checkout" tarihinin 2023-01-20
ve "additionalneeds“in,"wi-fi"
oldugunu test edi
     */

    @Test
    public void test11(){
         // 1_   end-point  ve request body hazirlama
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject requestbody=new JSONObject();
        JSONObject rezervasyonTarihleri=new JSONObject();

        rezervasyonTarihleri.put("checkin","2023-01-10");
        rezervasyonTarihleri.put("checkout","2023-01-20");

        requestbody.put("firstname","Ahmet");
        requestbody.put("lastname","Bulut");
        requestbody.put("totalprice",500);
        requestbody.put("depositpaid",false);
        requestbody.put("bookingdates",rezervasyonTarihleri);
        requestbody.put("additionalneeds","wi-fi");



        // 2- (varsa)  Expected data hazirlama  //soruda benden bunu istememis ve pass geciyoruz


        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given().contentType(ContentType.JSON)
                          .when().body(requestbody.toString())
                          .post(url);


        response.prettyPrint();//yazdiralim

        // 4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));

    }
}
