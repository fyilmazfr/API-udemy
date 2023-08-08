package Tests;

import Pojo.Data;
import Pojo.PojoDummyExampleResponse;
import baseUrl.BaseUrlDummyExample;
import org.junit.Test;

public class C33_Get_Pojo extends BaseUrlDummyExample {
    /*
    32 VE 33 . video da otomatik olarak pojo claslari olusturmayi gosteriyor
google'a json to pojo yazarsak ve body verirsek bize otomatik olarak ic ice pojolari olusturuyor
bizde bunu olusturacagimiz pojo claslarina yapistiriyoruz
    CONVERTOR KULLANARAK POJO ILE EXPECTED DATA TESTI


    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

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
        specDummyExample.pathParams("pp1", "employee", "pp2", "3");


        // 2- (varsa)  Expected data hazirlama


        // 3- Request gonderip donen reponse'i kaydetme

        // 4- Assertion


    }
}
