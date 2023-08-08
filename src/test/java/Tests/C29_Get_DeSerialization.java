package Tests;

import TestDatalari.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_DeSerialization extends BaseUrlDummyExample {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un status code’unun 200, content Type’inin application/json
ve body’sinin asagidaki gibi oldugunu test edin.

Response Body
{
"status": "success",
"data": {
         "id": 3,
          "employee_name": "Ashton Cox",
          "employee_salary": 86000,
          "employee_age": 66,
          "profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
     */
    @Test
    public void test01() {
        // 1_   end-point  ve request body hazirlama
        specDummyExample.pathParams("pp1","employee","pp2","3");


        // 2- (varsa)  Expected data hazirlama
        Map<String,Object> expectedData= TestDataDummyExample.MapbodyOlustur();
           System.out.println(expectedData);

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given().spec(specDummyExample)
                .when()
                .get("{pp1}/{pp2}");
          response.prettyPrint();

        // 4- Assertion
        Map<String,Object> responseMap=response.as(HashMap.class);

        assertEquals(TestDataDummyExample.basarilisorgustatusCOde,response.statusCode());
        assertEquals(TestDataDummyExample.contentType,response.contentType());

        assertEquals(expectedData.get("message"),responseMap.get("message"));
        assertEquals(expectedData.get("status"),responseMap.get("status"));

        assertEquals(((Map)expectedData.get("data")).get("profile_image"),(((Map)responseMap.get("data")).get("profile_image")));
        //burda parantes iicnden bilgi alacagimiz icin ve Map oldugu icin javaya bunu belirtmemiz lazim
        //yani cast yapmamiz lazim
        assertEquals(((Map)expectedData.get("data")).get("employee_name"),(((Map)responseMap.get("data")).get("employee_name")));
        assertEquals(((Map)expectedData.get("data")).get("employee_salary"),(((Map)responseMap.get("data")).get("employee_salary")));
        assertEquals(((Map)expectedData.get("data")).get("employee_age"),(((Map)responseMap.get("data")).get("employee_age")));
        assertEquals(((Map)expectedData.get("data")).get("profile_image"),(((Map)responseMap.get("data")).get("profile_image")));
    }
}
