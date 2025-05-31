package Utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class Parent {
    public RequestSpecification reqSpec;

    @BeforeClass
    public void setUp() {
        baseURI = "https://api.themoviedb.org";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + ConfigReader.getProperty("token"))
                .build();
    }
}