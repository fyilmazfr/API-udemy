package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}
}

Response Body
{ "status": "success",
"data": {
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40 }
},
"message": "Successfully! Record has been updated."}



     */

    @Test
    public void test16(){

        // 1_   end-point  ve request body hazirlama
        String url="http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody=new JSONObject();
        JSONObject dataBilgileri=new JSONObject();

        dataBilgileri.put("name","Ahmet");
        dataBilgileri.put("salary", "1230");
        dataBilgileri.put("age", "44");
        dataBilgileri.put("id", 40);

        requestBody.put("status", "success");
        requestBody.put("data",dataBilgileri);

        // 2- (varsa)  Expected data hazirlama

        JSONObject expectedData=new JSONObject();

        expectedData.put("status", "success");
        expectedData.put("data",requestBody);
        expectedData.put("message", "Successfully! Record has been updated.");


        // 3- Request gonderip donen reponse'i kaydetme
        Response response= given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                        .put(url);

        response.prettyPrint();

        // 4- Assertion
            //bunu soft assert ile yapacagiz bu yuzden
        JsonPath responseJsonPath=response.jsonPath();//Yukarida'ki gelen cevabi yani response'u kolay almak icin  jsonPath sekline cevirdik
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"), expectedData.get("status")); //actual, expected
        softAssert.assertEquals(responseJsonPath.get("message"), expectedData.get("message"));


        softAssert.assertEquals(responseJsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));

        softAssert.assertEquals(responseJsonPath.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),expectedData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJsonPath.get("data.data.age"),expectedData.getJSONObject("data").getJSONObject("data").get("age"));


          softAssert.assertAll();  //raporlama yapmamiz icin

        //86. satirda ic ice 3 json objesi oldugu icin ,icine girmek icin expected data 'da 2 kere getjson object dedik

    //NOT url sayfasi bulunamiyor !!!

    }
}
