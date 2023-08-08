package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
yolladigimizda donen response’in

   status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

     */
    @Test
    public void test01(){
        // 1_   end-point  ve request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        JSONObject requestBody= TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 2- (varsa)  Expected data hazirlama

        JSONObject expectedData=TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");



        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given().spec(specJsonPlaceHolder)
                .when().body(requestBody)
                .put("{pp1}/{pp2}");

        // 4- Assertion
        JsonPath responseJP=response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

                         //ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
        assertEquals(expectedData.getInt("id"),responseJP.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responseJP.getInt("userId"));
        Assert.assertEquals(expectedData.getString("title"),responseJP.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJP.getString("body"));






    }
}
