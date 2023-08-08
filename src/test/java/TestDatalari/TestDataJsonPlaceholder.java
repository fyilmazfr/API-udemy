package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceholder {
    public static int basariliSorguStatusCode = 200;

    public static JSONObject responseBodyOlustur22() {//id numarasi 22 olan body
        JSONObject expectedData = new JSONObject();

        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut/n sed omnis non odio/n expedita ear /num mollitia molestiae aut atque rem suscipit/n am impedit esse");


        return expectedData;

    }

    public static JSONObject JsonBodyOlustur(int userId, int id, String title, String body) {
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", userId);
        expectedData.put("id", id);
        expectedData.put("title", "title");
        expectedData.put("body", "body");

        return expectedData;
    }

    //iki ayri method olusturduk buraya kolaylik icin
    public static String contentType="application/json; charset=utf-8";

    public static String headerConnection="keep-alive";

    public static   Map<String, Object> bodyOlusturMap() { //object koyduk value degeri icin cunku hem stringi hemde int 'i icine alsin diye

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("title", "Ahmet");
        bodyMap.put("body", "Merhaba");
        bodyMap.put("userId", 10.0);
        bodyMap.put("id", 70.0);

        return bodyMap; // 28. class icin bunu olusturduk burada
    }
}



