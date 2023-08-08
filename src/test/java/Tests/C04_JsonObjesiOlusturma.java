package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjesiOlusturma {

    @Test
    public void test04(){
         // bir json object olusturalim ve asagidaki bilgileri ekleyelim bu objeye

        JSONObject obj1=new JSONObject();

        obj1.put("title" ,"AHMET");
        obj1.put("body" ,"Merhaba");
        obj1.put("userId",1);

        System.out.println(obj1);
    }
}
