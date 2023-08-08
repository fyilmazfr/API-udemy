package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholder {         //DE-SERIALIZATION ve MAP KULLANIMI
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

                                   //request body'sini MAP olarak olusturalim TestDataClass'inda
     Map<String,Object> requestBodyMap=TestDataJsonPlaceholder.bodyOlusturMap();
                    System.out.println(requestBodyMap);


        // 2- (varsa)  Expected data hazirlama

        Map<String,Object> expectedData=TestDataJsonPlaceholder.bodyOlusturMap();// zaten request ile expected ayni oldugu icin direk test datadan cektik

        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON) //ekledigimiz GSON kutuphanesi pom xml'de bizim yerimize bunu Mape cevirecek
                .when().body(requestBodyMap)
                .put("{pp1}/{pp2}");

            response.prettyPrint();

        // 4- Assertion

                   /*
                        assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir (DE-Serialization)
                   */

        Map<String,Object> responseMap=response.as(HashMap.class);
                System.out.println("Response Map:" +responseMap);   //Response Map:{id=70.0, title=Ahmet, body=Merhaba, userId=10.0}

            //expectedData (Map) <=======> responseMap(Map) iki map'i karsilastiralim

        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));
    }


}
