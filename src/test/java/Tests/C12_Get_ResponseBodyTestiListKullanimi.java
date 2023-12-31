package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTestiListKullanimi {
    @Test
    public void test12(){
       /* http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
        donen Response'in
        status code'unun 200,
        ve content type'inin Aplication.JSON,
        ve response body'sindeki
        employees sayisinin 24
        ve employee'lerden birinin "Ashton Cox"
        ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu
        test edin.

        */

        // 1_   end-point  ve request body hazirlama
        String url="http://dummy.restapiexample.com/api/v1/employees";
        JSONObject requestbody=new JSONObject();

        // 2- (varsa)  Expected data hazirlama

        // 3- Request gonderip donen reponse'i kaydetme
        Response response=given()
                .when()
                .get(url);

        response.prettyPrint();

        // 4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id",hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,21,35));

    }
}
