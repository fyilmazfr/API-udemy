package Tests;

import Pojo.PojoJsonPlaceHolder;
import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
oldugunu test ediniz

Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

Request Body
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
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);
        PojoJsonPlaceHolder requestBodyPojo=
                new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);


        // 2- (varsa)  Expected data hazirlama
        PojoJsonPlaceHolder expectedDataPojo=new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .put("{pp1}/{pp2}");


        // 4- Assertion
                     // expected data(Pojo) <======>response (Pojo)
        PojoJsonPlaceHolder responsePojo=response.as(PojoJsonPlaceHolder.class);
                     //expectedDataPojo karsisinda da responsePojo olustu

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());

    }

}
