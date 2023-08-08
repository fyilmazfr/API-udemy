package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {

    //soruyu yazmadim end pointe gidip 3. soruda ki istekleri yazdirdim

    @Test
    public void test01(){
        // 1_ request body ve end-point hazirlama
        String url="https://restful-booker.herokuapp.com/booking/4039";

        // 2- (varsa)  Expected data hazirlama

        // 3- Request gonderip donen reponse'i kaydetme

        Response response=given().when().get(url);

        System.out.println("StatusCode :"+response.getStatusCode()+
                "\nContent type :" + response.getContentType()+
                "\n Server header degeri :"+ response.getHeader("Server")+
                "\n Status Line degeri:"+ response.getStatusLine()+
                "\n Response suresi :" + response.getTime());

    }
}
