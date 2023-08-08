package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjectOlusturma {

    @Test
    public  void test01(){

        //once inner  JSON objesi olusturalim
        JSONObject dateJsonObject=new JSONObject();

        dateJsonObject.put("checkin", "2018-01-01");
        dateJsonObject.put("checkout" ,"2019-01-01");

        //sonra outer json objesini olusturup yeri geldiginde inner objeyi koyalim

        JSONObject requestbody=new JSONObject();

        requestbody.put("firstname","Jim");
        requestbody.put("additionalneeds", "Breakfast");
        requestbody.put("bookingdates",dateJsonObject);  //inner'i buraya ekledik
        requestbody.put("totalprice",111);
        requestbody.put("depositpaid",true);
        requestbody.put("lastname","Brown");

        System.out.println(requestbody);
    }

    /*
    {"firstname":"Jim",
    "additionalneeds":"Breakfast",
    "bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},
    "totalprice":111,
    "depositpaid":true,
    "lastname":"Brown"}
     */
}
