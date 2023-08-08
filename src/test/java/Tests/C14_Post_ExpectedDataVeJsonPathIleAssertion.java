package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {//post yeni kayit olusturma demektir
    /*
    JUNIT ile Hard assert
     */
    /* SORU
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin

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



Response Body
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

     */
    @Test
            public void test14(){

        // 1_   end-point  ve request body hazirlama
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody=new JSONObject();
        JSONObject rezTarihleri=new JSONObject();

        rezTarihleri.put("checkin", "2021-06-01");
        rezTarihleri.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezTarihleri);
        requestBody.put("additionalneeds", "wi-fi");



        // 2- (varsa)  Expected data hazirlama
        JSONObject expectedData=new JSONObject();

        expectedData.put("bookinid",24);
        expectedData.put("booking",requestBody);

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        // 4- Assertion

        JsonPath responseJsonPath=response.jsonPath();// gelen cevabi response'u json path haline donusturduk

        ;  //responseJsonPath = actual data

        //bu kismi yazmadim UDEMY 17. video Hard assert
        //expected data'dan gelen cevap ile response 'dan gelen cevabi karsilastiriyoruz









    }





}
