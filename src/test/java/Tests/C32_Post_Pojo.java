package Tests;

import Pojo.PojoHerOkuappBookingdates;
import Pojo.PojoHerokuappRequestBody;
import Pojo.PojoHerokuappResponse;
import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerOkuApp {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body // expected data
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}
}
Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}
     */

    @Test
    public void test01() {
        // 1_   end-point  ve request body hazirlama
        specHerOkuApp.pathParam("pp1", "booking");

        PojoHerOkuappBookingdates bookingdatesPojo = new PojoHerOkuappBookingdates("2021-06-01", "2021-06-10");
        PojoHerokuappRequestBody requestBodyPojo = new PojoHerokuappRequestBody("Ahmet", "Bulut", 500, false, bookingdatesPojo, "wi-fi");

        // 2- (varsa)  Expected data hazirlama

        bookingdatesPojo = new PojoHerOkuappBookingdates("2021-06-01", "2021-06-10");
        PojoHerokuappRequestBody bookingPojo = new PojoHerokuappRequestBody("Ahmet", "Bulut", 500, false, bookingdatesPojo, "wi-fi");

        PojoHerokuappResponse expectedResponseBodyPojo = new PojoHerokuappResponse(24, bookingPojo);

        System.out.println(expectedResponseBodyPojo);

        // 3- Request gonderip donen reponse'i kaydetme

        Response response = given().spec(specHerOkuApp).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .post("{pp1}");

                        response.prettyPrint();

        // 4- Assertion
        PojoHerokuappResponse responsePojo=response.as(PojoHerokuappResponse.class);

        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());

        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());

        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());

        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());

        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());


                 //simdi tekrar ice girelim
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());





    }
}
