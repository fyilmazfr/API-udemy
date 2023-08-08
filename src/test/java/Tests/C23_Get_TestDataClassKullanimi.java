package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */
    @Test
    public void test01(){
        // 1_   end-point  ve request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");

        // 2- (varsa)  Expected data hazirlama
       JSONObject expectedData=TestDataJsonPlaceholder.responseBodyOlustur22();// !!! testData class'indan cagirdik
        System.out.println(expectedData);


        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given().spec(specJsonPlaceHolder)
                .when()
                .get("{pp1}/{pp2}");



        // 4- Assertion
        JsonPath responseJsonPath=response.jsonPath();

        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());//bu kisim status codu
            //(TestDataJsonPlaceholder.basariliSorguStatusCode===> bu kisim expected data
             //response.statusCode()  actual data
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));//userId kismi  expected ve actual userid
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));

              //yazilarda hata var ama kodlarda sikinti yokk




    }
}
