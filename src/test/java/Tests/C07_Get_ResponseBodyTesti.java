package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {

    @Test
    public void test01(){//response body'lerden userId ve title'i test edecegiz

        // 1_ request body ve end-point hazirlama
        String url="https://jsonplaceholder.typicode.com/posts/44";


        // 2- (varsa)  Expected (body) data hazirlama

        // 3- Request gonderip donen reponse'i kaydet
        Response response=given().when().get(url);

        // 4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
}
