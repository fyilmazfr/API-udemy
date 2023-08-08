package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {

    /* SORU
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
    yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :
   {
     "userId": 3,
     "id": 22,
     "title": "dolor sint quo a velit explicabo quia nam",
     "body": "dolor sint quo a velit explicabo quia nam"
   }
     */

    @Test
    public  void test13(){

        // 1_   end-point  ve request body hazirlama
        String url="https://jsonplaceholder.typicode.com/posts/22";

        // 2- (varsa)  Expected data hazirlama

        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given()
                .when()
                .get(url);
                                    //response.prettyPrint();   ==>  gormek icin

        // 4- Assertion

        JsonPath responseJsonPathHali=response.jsonPath();//response'umuzu jsonPath haline cevirecek bu sayede

        Assert.assertEquals(expectedData.get("userId"),responseJsonPathHali.getInt("userId"));
        Assert.assertEquals(expectedData.get("id"),responseJsonPathHali.getInt("id"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPathHali.getString("body"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPathHali.getString("title"));



    }
}
