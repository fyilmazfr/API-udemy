package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerOkuApp {

    protected RequestSpecification specHerOkuApp; //farkli url ile calistigimiz icin isim verirken boyle yapiyoruz
                                         //normalde sadece specification dememiz yeterli
    @Before
    public void setUp(){

        specHerOkuApp=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
