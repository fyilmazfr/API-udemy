package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseUrlJsonPlaceholder {

    protected RequestSpecification specJsonPlaceHolder;//once burayi olusturuyoruz

    @Before
    public void setUp() {

        specJsonPlaceHolder = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }





}
