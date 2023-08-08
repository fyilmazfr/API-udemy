package NOTLAR;

public class Notlar {
    /*
    ***
    mvn story'den json , Junit, rest assured ==>   dependies'lere ekledik


    * Request gonderip donen reponse'i kaydetme

        Response response=given().when().get(url); // serverdan gelen cevabi response objesine atip bize verecek
        response.prettyPrint();    //bu response'in body'sini  gozumuzle de gormek icin


               * JSON OBJELERI
    .JSON'da key 'ler daima string olur
    .valu'lar ise atanan degerlerdir
    .JSON'da her turlu data turu koyabiliriz sag tarafa value'e ye


                      JsonPathKullanimi
     *SONPath JSON verilerini okuma ve update etme fırsatı verir
     * JsonPath responseJsonpath=response.jsonPath(); //donen cevabi jsonPath objesine donusturur

     *
                         JUnit ASSERT
     *herzaman boolen kosul'a gore calisir
     1 ) Assert.assertTrue(koşul
     2) Assert.assertFalse(koşul
     3) Assert.assertEqual(expected, actual)

*
        Response response=given().contentType(ContentType.JSON)
                .when()
                .get(url);
             get oldugu icin when 'den sonra body yapmayiz ,zaten bize getirecek get methodu ile

 * //softassert yapabilmemiz icin birinci adimimiz soft assert objesi olusturmak
              //oncelikle maven story'e testNG'i eklememiz lazim
              // <!-- https://mvnrepository.com/artifact/org.testng/testng -->
              once actual sonra expected yazilir



               FRAMEWORK OLUSTURMA
                BaseUrl
 *Path parametrelerini ogrenecegiz burda, base url den sonra gelenlere patah parametreleri denir
 * protected RequestSpecification specJsonPlaceHolder;//once burayi olusturuyoruz

    @Before
    public void setUp(){

        specJsonPlaceHolder=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
    * daha sonra calistigimiz test'de;
    specJsonPlaceHolder.pathParam("pp1","posts");  // bunu yapariz ve base url class'ina extend ederiz
    ve ardindan 3.adimda
    Response response=given()
                .when().spec(specJsonPlaceHolder)  //spec ile bodysini belirtiyoruz
                .get("/{pp1}");                    //get methodu kullanmisiz burda

* RequestSpecification specHerOkuApp; //farkli url ile calistigimiz icin isim verirken boyle yapiyoruz
                                         //normalde sadece specification dememiz yeterli



                       TEST DATA CLASS KULLANIMI
*Test Datasi Nedir ? : Bir test sirasinda request ile gonderilen (request body) veya test
sonucunda donmesi beklenen datalarin (expected data ve temel response bilgileri) tamamina
Test Datasi denir.


                            DE-SERILIZATION ve MAP kullanimi
* mvn story den GSON (ci san, diye okunur ) alip pom exm le copy past yapiyoruz


* 29.class'da parantezin icine girmek icin yaptik
  assertEquals(((Map)expectedData.get("data")).get("profile_image"),(((Map)responseMap.get("data")).get("profile_image")));
        //burda parantes iicnden bilgi alacagimiz icin ve Map oldugu icin javaya bunu belirtmemiz lazim
        //yani casting yapmamiz lazim



* C30_Post_Deserialization
   hoca yeni kucuk birsey gosteriyor ic ice parantezleri kolaylastirmak icin
   yeni bir maplerden olusan method olusturuyor testdata class'inda
   daha sonra assert yaparkende ic ice girerken iki kere Map oldugunu casting yaparak belirtiyor


                         POJO CLASS KULLANIMI
                         Pojo : Plain Old Java Object (Basit java objesi)
*Pojo kullaniminda her bir Json Objesi icin method degil
Class olusturacagiz.
* Pojo kullaniminda Java’daki encapsulation ozellikleri kullanilir !!!!!

* Kompleks Json objeleri icin otomatik olarak Pojo Class’lari
olusturan web-sitelerinden yardim alabiliriz.
* Basit yapidaki Json objeleri icin kendimiz de Pojo Class’lari
olusturabiliriz
*

  Bir POJO Class olusturmak icin, 5 adima ihtiyacimiz var
  * 1) Tum variable’lari "private" olarak olusturalim
  * 2) Tum variable’lar icin getter( ) and setter( ) metodlari
olusturalim
  *3) Tum parametreleri iceren bir constructor olusturalim

   *)4 Default constructor (parametresiz) olusturalim
   *5) toString( ) metodu olusturalim

                        CONVERTOR KULLANARAK POJO ILE EXPECTED DATA TESTI
....32 VE 33 . video da otomatik olarak pojo claslari olusturmayi gosteriyor
google'a json to pojo yazarsak ve body verirsek bize otomatik olarak ic ice pojolari olusturuyor
bizde bunu olusturacagimiz pojo claslarina yapistiriyoruz



                                  CUCUMBER  API FRAMEWORK
*cucumber BDD (behaviour driven development davranis tabanli gelistirme) yaklasimi kullanir


                                 KARATE FRAMEWORK
           *def baseUrl = 'https://jsonplaceholder.typicode.com'
          * def pathParams = '/posts/70'
          * def requestBody =
              ====>>> given yazmaktansa *def yazip tanimlama yapabiliriz, jorkin languge 'in bir uyesi  *
      */



}
