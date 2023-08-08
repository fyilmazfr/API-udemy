package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
        public void method(){

        JSONObject kisibilgileriJsonObj=new JSONObject();
        JSONObject adresJsonObj=new JSONObject();
        JSONArray telefonBilgileriARR=new JSONArray();
        JSONObject cepTelJsonOBJ=new JSONObject();
        JSONObject evtelJsonObj=new JSONObject();


        adresJsonObj.put("streetAdress","naist street");
        adresJsonObj.put("city","Nara");
        adresJsonObj.put("postalCode","630-0192");


        cepTelJsonOBJ.put("type","IPhone");
        cepTelJsonOBJ.put("number","0123-4567-8888");

        evtelJsonObj.put("type","home");
        evtelJsonObj.put("number","0123-4567-8910");


        telefonBilgileriARR.put(cepTelJsonOBJ);// 20 21. satirlari ekledik
        telefonBilgileriARR.put(evtelJsonObj);// 22 23. satirlari ekledik array'imize

        kisibilgileriJsonObj.put("firstName","John");
        kisibilgileriJsonObj.put("lastname","Doe");
        kisibilgileriJsonObj.put("age",26);
        kisibilgileriJsonObj.put("adress",adresJsonObj);//11.satiri icine ekledik
        kisibilgileriJsonObj.put("phoneNumbers",telefonBilgileriARR);//12.satiri icine ekledik

        System.out.println(kisibilgileriJsonObj);
        System.out.println("firstName :"+kisibilgileriJsonObj.get("firstName"));//ornek olarak bana bu bilgiyi getir dedim

        //ama daha kolay yolu 43.satir

        //https://jsonpath.com/ adresine gidip direk bilgileri ordan alabiliriz

    }
}
