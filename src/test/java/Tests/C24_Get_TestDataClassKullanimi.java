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

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/40 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 4,
"id": 40,
"title": "enim quo cumque",
"body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
}
     */
    @Test
    public void test01(){
        // 1_   end-point  ve request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","40");

        // 2- (varsa)  Expected data hazirlama
        JSONObject expectedData= TestDataJsonPlaceholder.JsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\\nipsum rem optio mollitia \n" +
                "quas\\nvoluptatem eum voluptas qui\\nunde omnis voluptatem iure quasi maxime voluptas nam");

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given().spec(specJsonPlaceHolder)
                .when()
                .get("{pp1}/{pp2}");

                                               //response.prettyPrint();

        // 4- Assertion
        JsonPath responseJsonpath=response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(expectedData.getInt("userId"),responseJsonpath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonpath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonpath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonpath.getString("body"));
    }
}
